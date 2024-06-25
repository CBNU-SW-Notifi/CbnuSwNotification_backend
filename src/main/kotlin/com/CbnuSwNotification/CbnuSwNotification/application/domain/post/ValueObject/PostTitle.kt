package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import lombok.EqualsAndHashCode
import lombok.ToString

@Embeddable
@ToString
@EqualsAndHashCode
class PostTitle(
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    val title: String,
) {
    init {
        checkValid(title)
    }

    private fun checkValid(value: String) {
        if (value.isBlank() || value.length > 255) {
            throw IllegalArgumentException("타이틀의 값이 정상적이지 않습니다")
        }
    }
}