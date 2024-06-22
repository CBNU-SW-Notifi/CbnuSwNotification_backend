package com.CbnuSwNotification.CbnuSwNotification.notification.controller.dto

import jakarta.validation.constraints.NotBlank

data class TokenUpdateRequest(
    @NotBlank
    val id: String,
    @NotBlank
    val token: String,
)