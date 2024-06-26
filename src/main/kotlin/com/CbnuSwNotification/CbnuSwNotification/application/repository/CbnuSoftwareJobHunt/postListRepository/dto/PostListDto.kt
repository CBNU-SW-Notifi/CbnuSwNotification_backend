package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postListRepository.dto

import java.time.LocalDateTime

data class PostListDto(
    val id: Long,
    val title: String,
    val createTime: LocalDateTime,
)
