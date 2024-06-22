package com.CbnuSwNotification.CbnuSwNotification.notification.token.domain

import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceId
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceToken
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Token(
    @Embedded
    val deviceId: DeviceId,
    @Embedded
    var token: DeviceToken,
){
    @Id
    @GeneratedValue
    @Column(name = "token_id")
    val id: Long? = null
}