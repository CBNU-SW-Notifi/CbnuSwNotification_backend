package com.CbnuSwNotification.CbnuSwNotification.test.repository

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.imageUrlRepository.CbnuSoftwareJobHuntImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postRepository.CbnuSoftwareJobHuntPostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.ImageUrlFixture
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CbnuSoftwareJobHuntImageUrlRepositoryTest(
    @Autowired private val cbnuSoftwareJobHuntImageUrlRepository: CbnuSoftwareJobHuntImageUrlRepository,
    @Autowired private val cbnuSoftwareJobHuntPostRepository: CbnuSoftwareJobHuntPostRepository,
) : SpringTestSetting() {
    lateinit var cbnuSoftwareJobHuntPost1: CbnuSoftwareJobHuntPost
    lateinit var cbnuSoftwareJobHuntPost2: CbnuSoftwareJobHuntPost


    @BeforeEach
    fun before() {
        cbnuSoftwareJobHuntPost1 = PostFixture.createPost()
        cbnuSoftwareJobHuntPost2 = PostFixture.createPost()
        cbnuSoftwareJobHuntPostRepository.save(cbnuSoftwareJobHuntPost1)
        cbnuSoftwareJobHuntPostRepository.save(cbnuSoftwareJobHuntPost2)
    }


    @Test
    fun findAllByPost() {
        val post1Images = mutableListOf<CbnuSoftwareJobHuntImageUrl>()
        val post2Images = mutableListOf<CbnuSoftwareJobHuntImageUrl>()
        for (i in 1..5) {
            val tmp1 = ImageUrlFixture.createUrlImage(cbnuSoftwareJobHuntPost1)
            cbnuSoftwareJobHuntImageUrlRepository.save(tmp1)
            post1Images.add(tmp1)

            val tmp2 = ImageUrlFixture.createUrlImage(cbnuSoftwareJobHuntPost2)
            cbnuSoftwareJobHuntImageUrlRepository.save(tmp2)
            post2Images.add(tmp2)
        }
        val imageUrlList1 = cbnuSoftwareJobHuntImageUrlRepository.findAllByPost(cbnuSoftwareJobHuntPost1)
        val imageUrlList2 = cbnuSoftwareJobHuntImageUrlRepository.findAllByPost(cbnuSoftwareJobHuntPost2)

        Assertions.assertThat(imageUrlList1.size).isEqualTo(post1Images.size)
        Assertions.assertThat(imageUrlList1).containsAll(post1Images)
        Assertions.assertThat(imageUrlList2.size).isEqualTo(post2Images.size)
        Assertions.assertThat(imageUrlList2).containsAll(post2Images)
    }

}