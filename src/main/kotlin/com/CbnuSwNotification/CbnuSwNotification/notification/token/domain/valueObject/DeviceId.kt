package com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject

import jakarta.persistence.Embeddable
import jakarta.persistence.Lob
import lombok.EqualsAndHashCode
import lombok.ToString
import java.io.Serializable

@Embeddable
@ToString
@EqualsAndHashCode
class DeviceId(
    @Lob
    val id: String
) : Serializable {


    init {
        checkValid(id)
    }

    private fun checkValid(value: String) {
        if (value.isBlank()) {
            throw IllegalArgumentException("디바이스 id의 값이 정상적이지 않습니다")
        }
    }

}