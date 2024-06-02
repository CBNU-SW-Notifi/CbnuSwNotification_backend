package com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.dto

import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import java.time.LocalDateTime

data class PostListDto(
    val id: Long,
    val title: String,
    val postType: PostType,
    val createTime: LocalDateTime,
)
