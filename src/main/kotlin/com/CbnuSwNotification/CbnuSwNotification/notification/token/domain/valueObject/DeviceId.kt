package com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject

import com.CbnuSwNotification.CbnuSwNotification.common.dataType.ValueObject
import jakarta.persistence.Lob
import java.io.Serializable


class DeviceId(
    @Lob
    val id: String
) : ValueObject<String>(), Serializable {

    init {
        checkValid(id)
    }

    override fun checkValid(value: String) {
        if(value.isBlank()){
            throw IllegalArgumentException("디바이스 id의 값이 정상적이지 않습니다")
        }
    }

}