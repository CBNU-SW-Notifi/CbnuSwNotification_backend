package com.CbnuSwNotification.CbnuSwNotification.notification.android

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.ResourceUtils
import java.io.FileInputStream

@Configuration
class FirebaseConfig(
    @Value("\${fcm.firebase-config-path}")
    private val firebaseConfigPath: String
) {

    @Bean
    fun firebaseApp():FirebaseApp{
        val fileInputStream = FileInputStream(ResourceUtils.getFile(firebaseConfigPath))

        val options = FirebaseOptions
            .builder()
            .setCredentials(GoogleCredentials.fromStream(fileInputStream))
            .build()
        if (FirebaseApp.getApps().size > 0) {
            return FirebaseApp.getApps().first()
        }
        return FirebaseApp.initializeApp(options)
    }

    @Bean
    fun fireMessaging(firebaseApp: FirebaseApp):FirebaseMessaging{
        return FirebaseMessaging.getInstance(firebaseApp)
    }
}