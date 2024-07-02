package com.CbnuSwNotification.CbnuSwNotification.application.service.CbnuSoftwareNotice

import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.attachedFileUrlRepository.CbnuSoftwareNoticeAttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.imageUrlRepository.CbnuSoftwareNoticeImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.postRepository.CbnuSoftwareNoticePostRepository
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.AttachedFileDto
import com.CbnuSwNotification.CbnuSwNotification.common.dto.postReadDto.PostReadResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CbnuSoftwareNoticePostReadService(
    private val imageUrlRepository: CbnuSoftwareNoticeImageUrlRepository,
    private val postRepository: CbnuSoftwareNoticePostRepository,
    private val attachedFileUrlRepository: CbnuSoftwareNoticeAttachedFileUrlRepository,
) {
    fun readPost(postId: Long): PostReadResponse? {
        val post = postRepository.findById(postId) ?: return null
        val imageUrls=imageUrlRepository.findAllByPost(post).map {
            it.url
        }
        val files=attachedFileUrlRepository.findAllByPost(post)
            .map{ AttachedFileDto(
                name = it.name.name,
                url = it.url,
            )
            }

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