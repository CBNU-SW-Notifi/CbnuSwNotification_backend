package com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto

import java.time.LocalDateTime

data class PostListDto(
    val id: Long,
    val title: String,
    val createTime: LocalDateTime,
)
