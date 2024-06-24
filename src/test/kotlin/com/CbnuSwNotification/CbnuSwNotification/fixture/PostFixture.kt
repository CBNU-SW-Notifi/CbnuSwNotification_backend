package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import java.time.LocalDateTime

class PostFixture {
    companion object{
        fun createPost(): CbnuSoftwareJobHuntPost {
            return CbnuSoftwareJobHuntPost(
                title = "테스트",
                content = "테스트 내용",
                postType = PostType.COMMON,
                createTime = LocalDateTime.now(),
            )
        }

        fun createPost(str:String): CbnuSoftwareJobHuntPost {
            return CbnuSoftwareJobHuntPost(
                title = "테스트",
                content = str,
                postType = PostType.COMMON,
                createTime = LocalDateTime.now(),
            )
        }
    }
}