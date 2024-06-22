package com.CbnuSwNotification.CbnuSwNotification.notification.controller.dto

import jakarta.validation.constraints.NotBlank

data class NotificationRequest(
    @NotBlank
    val title: String,
    @NotBlank
    val body: String,
)
