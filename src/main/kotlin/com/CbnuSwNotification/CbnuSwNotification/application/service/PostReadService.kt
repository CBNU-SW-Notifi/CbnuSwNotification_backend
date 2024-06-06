package com.CbnuSwNotification.CbnuSwNotification.application.service

import com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository.AttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrlRepository.ImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.AttachedFileDto
import com.CbnuSwNotification.CbnuSwNotification.common.dto.postReadDto.PostReadResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostReadService(
    private val postRepository: PostRepository,
    private val imageUrlRepository: ImageUrlRepository,
    private val attachedFileUrlRepository: AttachedFileUrlRepository,
) {
    fun readPost(postId: Long): PostReadResponse? {
        val post = postRepository.findById(postId) ?: return null
        val imageUrls=imageUrlRepository.findAllByPost(post).map {
            it.url
        }
        val files=attachedFileUrlRepository.findAllByPost(post)
            .map{ AttachedFileDto(
                name = it.name,
                url = it.url,
            )}

        return PostReadResponse(
            postId = post.id!!,
            title = post.title,
            content = post.content,
            imageUrls = imageUrls,
            attachedFiles = files,
            postType = post.postType,
            createTime = post.createTime,
            )

    }
}