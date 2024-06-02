package com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto

data class CursorResultResponse<T>(
    val value: List<T>,
    val hasNext: Boolean,
    val lastIndex: Long,
)
