package com.CbnuSwNotification.CbnuSwNotification.application.service

import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.attachedFileUrlRepository.CbnuSoftwareJobHuntAttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.imageUrlRepository.CbnuSoftwareJobHuntImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postRepository.CbnuSoftwareJobHuntPostRepository
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.AttachedFileDto
import com.CbnuSwNotification.CbnuSwNotification.common.dto.postReadDto.PostReadResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CbnuSoftwareJobHuntPostReadService(
    private val cbnuSoftwareJobHuntPostRepository: CbnuSoftwareJobHuntPostRepository,
    private val cbnuSoftwareJobHuntImageUrlRepository: CbnuSoftwareJobHuntImageUrlRepository,
    private val cbnuSoftwareJobHuntAttachedFileUrlRepository: CbnuSoftwareJobHuntAttachedFileUrlRepository,
) {
    fun readPost(postId: Long): PostReadResponse? {
        val post = cbnuSoftwareJobHuntPostRepository.findById(postId) ?: return null
        val imageUrls=cbnuSoftwareJobHuntImageUrlRepository.findAllByPost(post).map {
            it.url
        }
        val files=cbnuSoftwareJobHuntAttachedFileUrlRepository.findAllByPost(post)
            .map{ AttachedFileDto(
                name = it.name.name,
                url = it.url,
            )}

        return PostReadResponse(
            postId = post.id!!,
            title = post.title.title,
            content = post.content.content,
            imageUrls = imageUrls,
            attachedFiles = files,
            createTime = post.createTime,
            )

    }
}