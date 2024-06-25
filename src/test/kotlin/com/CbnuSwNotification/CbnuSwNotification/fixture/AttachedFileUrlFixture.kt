package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.AttachedFileName
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntAttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

class AttachedFileUrlFixture {
    companion object{
        fun createAttachedFileUrl(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): CbnuSoftwareJobHuntAttachedFileUrl {
            return CbnuSoftwareJobHuntAttachedFileUrl(
                name = AttachedFileName("테스트"),
                url = "www.a.com",
                post = cbnuSoftwareJobHuntPost
            )
        }
    }
}