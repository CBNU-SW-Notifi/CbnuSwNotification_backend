package com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject

import jakarta.persistence.Embeddable
import jakarta.persistence.Lob
import lombok.EqualsAndHashCode
import lombok.ToString

@Embeddable
@ToString
@EqualsAndHashCode
class DeviceToken(
    @Lob
    val token: String,
) {

    init {
        checkValid(token)
    }
    private fun checkValid(value: String) {
        if(value.isBlank()){
            throw IllegalArgumentException("디바이스 토큰의 값이 정상적이지 않습니다")
        }
    }

}