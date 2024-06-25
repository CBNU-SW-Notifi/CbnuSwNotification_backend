package com.CbnuSwNotification.CbnuSwNotification.test.entity.valueObject

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.AttachedFileName
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceToken
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class AttachedFileNameTest {
    @Test
    fun formalTest(){
        val value = "ahgvghvasviu54165108"
        val attachedFileName = AttachedFileName(value)
        Assertions.assertThat(attachedFileName.name).isEqualTo(value)
    }

    @Test
    fun blankTest(){
        val value = "        "

        Assertions.assertThatThrownBy {
            AttachedFileName(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun emptyTest(){
        val value = ""

        Assertions.assertThatThrownBy {
            AttachedFileName(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}