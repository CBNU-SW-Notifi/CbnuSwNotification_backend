package com.CbnuSwNotification.CbnuSwNotification.common.dataType

import jakarta.persistence.Embeddable
import lombok.EqualsAndHashCode
import lombok.ToString

@Embeddable
@ToString
@EqualsAndHashCode
abstract class ValueObject<T> {

    /**
     * 값이 조건에 맞는지 판단
     * @param value 값이 조건에 맞는지 판단할 값
     * @return 조건에 맞을 경우 true 아닐 경우 false
     */
    protected abstract fun isValid(value: T): Boolean

}