package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Lob
import lombok.EqualsAndHashCode
import lombok.ToString

@Embeddable
@ToString
@EqualsAndHashCode
class PostContent(
    @Column(columnDefinition = "VARCHAR(20000) CHARACTER SET UTF8")
    val content: String,
) {
    init {
        checkValid(content)
    }

    private fun checkValid(value: String) {
        if (value.length > 20000) {
            throw IllegalArgumentException("본문의 값이 정상적이지 않습니다")
        }
    }
}