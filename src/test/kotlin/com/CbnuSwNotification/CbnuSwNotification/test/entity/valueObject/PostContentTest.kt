package com.CbnuSwNotification.CbnuSwNotification.test.entity.valueObject

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostContent
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PostContentTest {
    @Test
    fun formalTest(){
        val value = "ahgvghvasviu54165108"
        val deviceToken = PostContent(value)
        Assertions.assertThat(deviceToken.content).isEqualTo(value)
    }
    @Test
    fun formalTest2(){
        var value=""
        for (i in 0 until 20000){
            value+="가"
        }
        val deviceToken = PostContent(value)
        Assertions.assertThat(deviceToken.content).isEqualTo(value)
    }
}