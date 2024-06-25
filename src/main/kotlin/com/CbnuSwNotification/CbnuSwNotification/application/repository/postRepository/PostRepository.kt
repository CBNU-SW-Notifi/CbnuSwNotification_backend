package com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

interface PostRepository {

    fun save(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost) :Long

    fun findById(id: Long): CbnuSoftwareJobHuntPost?
}