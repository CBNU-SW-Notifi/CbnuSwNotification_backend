package com.CbnuSwNotification.CbnuSwNotification.repository

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrlRepository.ImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.ImageUrlFixture
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class ImageUrlRepositoryTest(
    @Autowired private val imageUrlRepository: ImageUrlRepository,
    @Autowired private val postRepository: PostRepository,
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
    fun findAllByPost() {
        val post1Images = mutableListOf<ImageUrl>()
        val post2Images = mutableListOf<ImageUrl>()
        for (i in 1..5) {
            val tmp1 = ImageUrlFixture.createUrlImage(post1)
            imageUrlRepository.save(tmp1)
            post1Images.add(tmp1)

            val tmp2 = ImageUrlFixture.createUrlImage(post2)
            imageUrlRepository.save(tmp2)
            post2Images.add(tmp2)
        }
        val imageUrlList1 = imageUrlRepository.findAllByPost(post1)
        val imageUrlList2 = imageUrlRepository.findAllByPost(post2)

        Assertions.assertThat(imageUrlList1.size).isEqualTo(post1Images.size)
        Assertions.assertThat(imageUrlList1).containsAll(post1Images)
        Assertions.assertThat(imageUrlList2.size).isEqualTo(post2Images.size)
        Assertions.assertThat(imageUrlList2).containsAll(post2Images)
    }

}