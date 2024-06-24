package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

class ImageUrlFixture {

    companion object{
        fun createUrlImage(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): CbnuSoftwareJobHuntImageUrl {
            return CbnuSoftwareJobHuntImageUrl("www.a.com", cbnuSoftwareJobHuntPost)
        }
    }
}