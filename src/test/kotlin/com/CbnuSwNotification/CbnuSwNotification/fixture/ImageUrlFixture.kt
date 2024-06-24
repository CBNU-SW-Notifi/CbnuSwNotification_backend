package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.ImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

class ImageUrlFixture {

    companion object{
        fun createUrlImage(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): ImageUrl {
            return ImageUrl("www.a.com", cbnuSoftwareJobHuntPost)
        }
    }
}