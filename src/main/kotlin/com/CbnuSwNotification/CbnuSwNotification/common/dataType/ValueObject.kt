package com.CbnuSwNotification.CbnuSwNotification.common.dataType

import jakarta.persistence.Embeddable
import lombok.EqualsAndHashCode
import lombok.ToString

@Embeddable
@ToString
@EqualsAndHashCode
abstract class ValueObject<T> {

    /**
     * 값이 조건에 맞는지 판단, 조건에 맞지 않을 경우 에러 발생
     * @param value 값이 조건에 맞는지 판단할 값
     */
    protected abstract fun isValid(value: T)

}