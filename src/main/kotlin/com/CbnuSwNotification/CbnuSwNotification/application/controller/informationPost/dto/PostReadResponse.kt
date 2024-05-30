package com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost.dto

import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class PostReadResponse(
    val postId: Long,
    val title: String,
    val content: String,
    val imageUrls: List<String>,
    val attachedFiles: List<String>,
    val postType: PostType,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
    )
    val createTime: LocalDateTime,
)
