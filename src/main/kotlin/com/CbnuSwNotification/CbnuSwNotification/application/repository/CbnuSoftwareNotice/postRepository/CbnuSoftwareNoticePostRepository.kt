package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.postRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticePost


interface CbnuSoftwareNoticePostRepository {
    fun save(post: CbnuSoftwareNoticePost) :Long

    fun findById(id: Long): CbnuSoftwareNoticePost?
}