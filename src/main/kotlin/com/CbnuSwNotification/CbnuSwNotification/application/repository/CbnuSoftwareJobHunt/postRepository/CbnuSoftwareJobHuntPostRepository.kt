package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

interface CbnuSoftwareJobHuntPostRepository {

    fun save(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost) :Long

    fun findById(id: Long): CbnuSoftwareJobHuntPost?
}