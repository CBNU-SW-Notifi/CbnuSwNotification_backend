package com.CbnuSwNotification.CbnuSwNotification.test.entity.valueObject


import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostTitle
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PostTitleTest {
    @Test
    fun formalTest(){
        val value = "ahgvghvasviu54165108"
        val deviceToken = PostTitle(value)
        Assertions.assertThat(deviceToken.title).isEqualTo(value)
    }
    @Test
    fun formalTest2(){
        val value = "가가ㅏ가ㅏ가ㅏ가ㅏ가ㅏ가ㅏ라ㅏ이ㅗㅓㅣㅜㅑㅐㅓㅠ뉴ㅑㄴ유ㅑ유ㅕㅠ야녀ㅠ냐ㅕㅠㅑㅕㅠㄴ야ㅠㅑㅠㅑ녀유ㅑㅕㅠㅕㅑㅠㅑ녀유ㅠㅕㅑㅠㅜㅑㅕㅠㅜ녀ㅑ유ㅜㅑㅕㅠㅕㅑ뉴ㅑㅕㅠㅑㅕㅠㅈ뎌ㅑㅠㅕㅑㅠㅕㅑㅠㅕㅑ쥬댜ㅕㅠㅕㅑㅠ져ㅑ듀ㅕㅑㅠㅕㅑㅈㄷ유ㅕㅑㅠㅕㅑㅠㅈ댜여ㅠㅕㅑㅠ져ㅑㅠㅕㅑㅠㅕㅑㅠㅇ뎌ㅑㅠㅕㅑㅠㅑㅕㅠㅈ야ㅕㅠㅑ즁뎌ㅑㅠㅑㅕㅠㅕㅑㅈ듀ㅕㅑㅠㅑㅕㅠㅈ뎌ㅑ유ㅕㅑㅠㅕㅑ쥬여ㅑㅠㅕㅑㅈ듀야ㅠㅕㅑㅠㄷ쟈ㅕㅠㅑㅕㅠㅕㅑㅈ듀ㅑㅕㅠㅑㅕㅠㅈㄷ여ㅑㅠㅕㅑㅠㅈ뎌ㅑㅠㅑㅕㅠㅈ댜ㅕㅠㅑㅕㅠㅕㅑㅗㄹ도ㅓㅈㅇ펴폎녚료ㅕ펴ㅛ펴ㅛㅈ포ㅠㅣㅑㅠㄹ댜뷰"
        val deviceToken = PostTitle(value)
        Assertions.assertThat(deviceToken.title).isEqualTo(value)
    }

    @Test
    fun blankTest(){
        val value = "        "

        Assertions.assertThatThrownBy {
            PostTitle(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun emptyTest(){
        val value = ""

        Assertions.assertThatThrownBy {
            PostTitle(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun overflowTest(){
        val value =
            "가가ㅏ가ㅏ가ㅏ가ㅏ가ㅏ가ㅏ라ㅏ이ㅗㅓㅣㅜㅑㅐㅓㅠ뉴ㅑㄴ유ㅑ유ㅕㅠ야녀ㅠ냐ㅕㅠㅑㅕㅠㄴ야ㅠㅑㅠㅑ녀유ㅑㅕㅠㅕㅑㅠㅑ녀유ㅠㅕㅑㅠㅜㅑㅕㅠㅜ녀ㅑ유ㅜㅑㅕㅠㅕㅑ뉴ㅑㅕㅠㅑㅕㅠㅈ뎌ㅑㅠㅕㅑㅠㅕㅑㅠㅕㅑ쥬댜ㅕㅠㅕㅑㅠ져ㅑ듀ㅕㅑㅠㅕㅑㅈㄷ유ㅕㅑㅠㅕㅑㅠㅈ댜여ㅠㅕㅑㅠ져ㅑㅠㅕㅑㅠㅕㅑㅠㅇ뎌ㅑㅠㅕㅑㅠㅑㅕㅠㅈ야ㅕㅠㅑ즁뎌ㅑㅠㅑㅕㅠㅕㅑㅈ듀ㅕㅑㅠㅑㅕㅠㅈ뎌ㅑ유ㅕㅑㅠㅕㅑ쥬여ㅑㅠㅕㅑㅈ듀야ㅠㅕㅑㅠㄷ쟈ㅕㅠㅑㅕㅠㅕㅑㅈ듀ㅑㅕㅠㅑㅕㅠㅈㄷ여ㅑㅠㅕㅑㅠㅈ뎌ㅑㅠㅑㅕㅠㅈ댜ㅕㅠㅑㅕㅠㅕㅑㅗㄹ도ㅓㅈㅇ펴폎녚료ㅕ펴ㅛ펴ㅛㅈ포ㅠㅣㅑㅠㄹ댜뷰ㅑㅕ"

        Assertions.assertThatThrownBy {
            PostTitle(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}