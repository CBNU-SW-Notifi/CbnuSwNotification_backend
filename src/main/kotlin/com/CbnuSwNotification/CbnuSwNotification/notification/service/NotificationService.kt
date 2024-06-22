package com.CbnuSwNotification.CbnuSwNotification.notification.service

import com.CbnuSwNotification.CbnuSwNotification.notification.android.AndroidNotification
import com.CbnuSwNotification.CbnuSwNotification.notification.token.repository.TokenRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class NotificationService(
    private val androidNotification: AndroidNotification,
    private val tokenRepository: TokenRepository,
) {
    fun sendMessageToAllUser(title:String,body:String){
        val tokens = tokenRepository.getAllDeviceToken()
        if (tokens.isNotEmpty()) {
            androidNotification.sendMessage(tokens, title, body)
        }
    }

    fun updateToken(id:String,token:String){
        tokenRepository.updateTokenByAndroidId(id, token)
    }
}
