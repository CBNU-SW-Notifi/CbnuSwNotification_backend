package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.AttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

class AttachedFileUrlFixture {
    companion object{
        fun createAttachedFileUrl(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): AttachedFileUrl {
            return AttachedFileUrl("테스트", "www.a.com", cbnuSoftwareJobHuntPost)
        }
    }
}