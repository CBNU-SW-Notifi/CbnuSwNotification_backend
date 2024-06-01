package com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post

interface PostRepository {

    fun save(post: Post) :Long

    fun findById(id: Long): Post?
}