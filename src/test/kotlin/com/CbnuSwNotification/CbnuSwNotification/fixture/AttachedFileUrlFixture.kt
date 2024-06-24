package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntAttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

class AttachedFileUrlFixture {
    companion object{
        fun createAttachedFileUrl(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): CbnuSoftwareJobHuntAttachedFileUrl {
            return CbnuSoftwareJobHuntAttachedFileUrl("테스트", "www.a.com", cbnuSoftwareJobHuntPost)
        }
    }
}