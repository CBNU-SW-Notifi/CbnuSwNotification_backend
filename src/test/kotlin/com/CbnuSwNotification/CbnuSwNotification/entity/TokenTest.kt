package com.CbnuSwNotification.CbnuSwNotification.entity

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.Token
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceId
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceToken
import com.CbnuSwNotification.CbnuSwNotification.notification.token.repository.TokenRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class TokenTest(
    @Autowired private val tokenRepository: TokenRepository,
) : SpringTestSetting() {

    @Test
    fun tokenTest(){
        val token = Token(
            deviceId = DeviceId("gshjbvauhb76788"),
            token = DeviceToken("34345345676gshghj"),
        )
        tokenRepository.save(token)
    }

}