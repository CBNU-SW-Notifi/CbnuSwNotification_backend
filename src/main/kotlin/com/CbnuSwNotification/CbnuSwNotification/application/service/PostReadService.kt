package com.CbnuSwNotification.CbnuSwNotification.application.service

import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.common.dto.postReadDto.PostReadResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostReadService(
    private val postRepository: PostRepository,
) {
    fun readPost(postId: Long): PostReadResponse {
        val post = postRepository.findById(postId) ?: throw IllegalArgumentException("없는 게시글 입니다")

        return PostReadResponse(
            postId = post.id!!,
            title = post.title,
            content = post.content,
            imageUrls = listOf(),
            attachedFiles = listOf(),
            postType = post.postType,
            createTime = post.createTime,
            )

    }
}