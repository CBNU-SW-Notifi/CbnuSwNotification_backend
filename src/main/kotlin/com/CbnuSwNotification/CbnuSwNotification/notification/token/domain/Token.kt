package com.CbnuSwNotification.CbnuSwNotification.notification.token.domain

import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceId
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceToken
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Lob

@Entity
class Token(
    @EmbeddedId
    val id: DeviceId,
    @Embedded
    var token:DeviceToken,
)