package com.CbnuSwNotification.CbnuSwNotification.repository

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.AttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository.AttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.AttachedFileUrlFixture
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class AttachedFileUrlRepositoryTest(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val attachedFileUrlRepository: AttachedFileUrlRepository,
) : SpringTestSetting() {
    lateinit var post1: Post
    lateinit var post2: Post


    @BeforeEach
    fun before() {
        post1 = PostFixture.createPost()
        post2 = PostFixture.createPost()
        postRepository.save(post1)
        postRepository.save(post2)
    }

    @Test
    fun findAllAttachedFileByPost(){
        val files1 = mutableListOf<AttachedFileUrl>()
        val files2 = mutableListOf<AttachedFileUrl>()

        for(i in 1..5){
            val tmp1 = AttachedFileUrlFixture.createAttachedFileUrl(post1)
            attachedFileUrlRepository.save(tmp1)
            files1.add(tmp1)

            val tmp2 = AttachedFileUrlFixture.createAttachedFileUrl(post2)
            attachedFileUrlRepository.save(tmp2)
            files2.add(tmp2)
        }
        val result1 = attachedFileUrlRepository.findAllByPost(post1)
        val result2 = attachedFileUrlRepository.findAllByPost(post2)


        Assertions.assertThat(result1.size).isEqualTo(files1.size)
        Assertions.assertThat(result1).containsAll(files1)
        Assertions.assertThat(result2.size).isEqualTo(files2.size)
        Assertions.assertThat(result2).containsAll(files2)

    }
}