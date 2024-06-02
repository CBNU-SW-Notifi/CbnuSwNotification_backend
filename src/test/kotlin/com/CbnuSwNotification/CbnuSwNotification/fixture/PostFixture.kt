package com.CbnuSwNotification.CbnuSwNotification.fixture

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import java.time.LocalDateTime

class PostFixture {
    companion object{
        fun createPost(): Post{
            return Post(
                title = "테스트",
                content = "테스트 내용",
                postType = PostType.COMMON,
                createTime = LocalDateTime.now(),
            )
        }
    }
}