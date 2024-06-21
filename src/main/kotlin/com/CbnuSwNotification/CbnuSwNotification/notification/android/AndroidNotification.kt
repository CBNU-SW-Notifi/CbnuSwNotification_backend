package com.CbnuSwNotification.CbnuSwNotification.notification.android

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.MulticastMessage
import com.google.firebase.messaging.Notification
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class AndroidNotification(
    private val firebaseMessaging: FirebaseMessaging,
) {

    fun sendMessage(token: String, title: String, body: String) {
        val message = makeMessage(token, title, body)
        firebaseMessaging.send(message)
    }

    fun sendMessage(tokens: List<String>, title: String, body: String) {
        val message = makeMulticastMessage(tokens, title, body)
        firebaseMessaging.sendEachForMulticast(message)
    }

    private fun makeMessage(token:String,title:String,body:String):Message{
        val notification = Notification.builder()
            .setTitle(title)
            .setBody(body)
            .build()

        return Message.builder()
            .setNotification(notification)
            .setToken(token)
            .build()
    }

    private fun makeMulticastMessage(tokens: List<String>, title: String, body: String): MulticastMessage {
        val notification = Notification.builder()
            .setTitle(title)
            .setBody(body)
            .build()

        return MulticastMessage.builder()
            .setNotification(notification)
            .addAllTokens(tokens)
            .build()
    }
}