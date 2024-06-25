package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostContent
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostTitle
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import java.time.LocalDateTime

class PostFixture {
    companion object{
        fun createPost(): CbnuSoftwareJobHuntPost {
            return CbnuSoftwareJobHuntPost(
                title = PostTitle("테스트"),
                content = PostContent("테스트 내용"),
                createTime = LocalDateTime.now(),
            )
        }

        fun createPost(str:String): CbnuSoftwareJobHuntPost {
            return CbnuSoftwareJobHuntPost(
                title = PostTitle("테스트"),
                content = PostContent(str),
                createTime = LocalDateTime.now(),
            )
        }
    }
}