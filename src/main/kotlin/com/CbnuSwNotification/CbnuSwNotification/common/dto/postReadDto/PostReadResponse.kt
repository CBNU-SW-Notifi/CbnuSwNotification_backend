package com.CbnuSwNotification.CbnuSwNotification.common.dto.postReadDto

import com.CbnuSwNotification.CbnuSwNotification.common.dataType.AttachedFileDto
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class PostReadResponse(
    val postId: Long,
    val title: String,
    val content: String,
    val imageUrls: List<String>,
    val attachedFiles: List<AttachedFileDto>,
    val postType: PostType,
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
    )
    val createTime: LocalDateTime,
)
