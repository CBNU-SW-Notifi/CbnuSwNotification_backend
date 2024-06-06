package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post

class ImageUrlFixture {

    companion object{
        fun createUrlImage(post: Post):ImageUrl{
            return ImageUrl("www.a.com", post)
        }
    }
}