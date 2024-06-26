package com.CbnuSwNotification.CbnuSwNotification.test.service

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository.AttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrlRepository.ImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.application.service.PostReadService
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.AttachedFileDto
import com.CbnuSwNotification.CbnuSwNotification.fixture.AttachedFileUrlFixture
import com.CbnuSwNotification.CbnuSwNotification.fixture.ImageUrlFixture
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CbnuSoftwareJobHuntPostReadServiceTest(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val imageUrlRepository: ImageUrlRepository,
    @Autowired private val attachedFileUrlRepository: AttachedFileUrlRepository,
    @Autowired private val postReadService: PostReadService,
) : SpringTestSetting() {

    private lateinit var cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost
    private val images = mutableListOf<String>()
    private val files = mutableListOf<AttachedFileDto>()

    @BeforeEach
    fun before() {
        cbnuSoftwareJobHuntPost = PostFixture.createPost()
        postRepository.save(cbnuSoftwareJobHuntPost)
        for (i in 1..3) {
            val tmp = ImageUrlFixture.createUrlImage(cbnuSoftwareJobHuntPost)
            imageUrlRepository.save(tmp)
            images.add(tmp.url)
        }

        for (i in 1..3) {
            val tmp = AttachedFileUrlFixture.createAttachedFileUrl(cbnuSoftwareJobHuntPost)
            attachedFileUrlRepository.save(tmp)
            files.add(
                AttachedFileDto(
                    name = tmp.name.name,
                    url = tmp.url,
                )
            )
        }
    }

    @Test
    fun postReadTest() {
        val result = postReadService.readPost(cbnuSoftwareJobHuntPost.id!!) ?: throw Exception()

        Assertions.assertThat(result.attachedFiles.size).isEqualTo(files.size)
        Assertions.assertThat(result.imageUrls.size).isEqualTo(images.size)
        Assertions.assertThat(result.postId).isEqualTo(cbnuSoftwareJobHuntPost.id)
    }
}