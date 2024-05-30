package com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost.dto

data class CursorResultResponse<T>(
    val value: List<T>,
    val hasNext: Boolean,
    val lastIndex: Long,
)
