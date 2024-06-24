package com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class PostMetadataResponse(
    val postId: Long,
    val title: String,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
    )
    val createTime: LocalDateTime,
)