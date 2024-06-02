package com.CbnuSwNotification.CbnuSwNotification.entity

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime

class PostEntityTest(
    @Autowired private val postRepository: PostRepository,
):SpringTestSetting(){

    @Test
    fun savePost(){
        val post = PostFixture.createPost()
        val id = postRepository.save(post)

        Assertions.assertThat(postRepository.findById(id)).isSameAs(post)
        Assertions.assertThat(post.id).isNotNull()
        Assertions.assertThat(post.saveTime).isNotNull()
        Assertions.assertThat(post.saveTime).isBefore(LocalDateTime.now())
    }

}