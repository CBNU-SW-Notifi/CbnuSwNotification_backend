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
    fun readPost(postId: Long): PostReadResponse? {
        val post = postRepository.findById(postId) ?: return null
        //TODO: 사진 및 첨부파일 추가
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