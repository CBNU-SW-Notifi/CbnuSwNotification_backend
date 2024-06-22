package com.CbnuSwNotification.CbnuSwNotification.test.entity.valueObject

import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceToken
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class DeviceTokenTest {
    @Test
    fun formalTest(){
        val value = "ahgvghvasviu54165108"
        val deviceToken = DeviceToken(value)
        Assertions.assertThat(deviceToken.token).isEqualTo(value)
    }

    @Test
    fun blankTest(){
        val value = "        "

        Assertions.assertThatThrownBy {
            DeviceToken(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun emptyTest(){
        val value = ""

        Assertions.assertThatThrownBy {
            DeviceToken(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}