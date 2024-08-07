package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import lombok.EqualsAndHashCode
import lombok.ToString

@Embeddable
@ToString
@EqualsAndHashCode
class AttachedFileName(
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    val name: String,
) {
    init {
        checkValid(name)
    }

    private fun checkValid(value: String) {
        if (value.isBlank() || value.length > 255) {
            throw IllegalArgumentException("첨부파일 명 '${value}'이 정상적이지 않습니다")
        }
    }
}