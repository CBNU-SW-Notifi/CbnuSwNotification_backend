package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.AttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post

class AttachedFileUrlFixture {
    companion object{
        fun createAttachedFileUrl(post: Post): AttachedFileUrl {
            return AttachedFileUrl("테스트", "www.a.com", post)
        }
    }
}