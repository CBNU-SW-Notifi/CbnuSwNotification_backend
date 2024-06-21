package com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject

import com.CbnuSwNotification.CbnuSwNotification.common.dataType.ValueObject
import jakarta.persistence.Lob
import kotlin.reflect.jvm.internal.ReflectProperties.Val

class DeviceToken(
    @Lob
    val token: String,
) : ValueObject<String>() {

    init {
        checkValid(token)
    }
    override fun checkValid(value: String) {
        if(value.isBlank()){
            throw IllegalArgumentException("디바이스 토큰의 값이 정상적이지 않습니다")
        }
    }

}