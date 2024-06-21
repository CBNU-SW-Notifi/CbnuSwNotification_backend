package com.CbnuSwNotification.CbnuSwNotification.entity.valueObject

import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceId
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class DeviceIdTest {

    @Test
    fun deviceIdTest(){
        val value = "ahgvghvasviu54165108"
        val deviceId = DeviceId(value)
        Assertions.assertThat(deviceId.id).isEqualTo(value)
    }

    @Test
    fun blankTest(){
        val value = "        "

        Assertions.assertThatThrownBy {
            DeviceId(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun emptyTest(){
        val value = ""

        Assertions.assertThatThrownBy {
            DeviceId(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

}