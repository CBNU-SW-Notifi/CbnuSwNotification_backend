package com.CbnuSwNotification.CbnuSwNotification.test.service

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postRepository.CbnuSoftwareJobHuntPostRepository
import com.CbnuSwNotification.CbnuSwNotification.application.service.CbnuSoftwareJobHunt.CbnuSoftwareJobHuntPostListService
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.math.min

class CbnuSoftwareJobHuntPostListServiceTest(
    @Autowired private val cbnuSoftwareJobHuntPostListService: CbnuSoftwareJobHuntPostListService,
    @Autowired private val cbnuSoftwareJobHuntPostRepository: CbnuSoftwareJobHuntPostRepository,
) : SpringTestSetting() {

    val postList = mutableListOf<Long>()
    @BeforeEach
    fun before() {
        for (i in 1..10) {
            postList.add(cbnuSoftwareJobHuntPostRepository.save(PostFixture.createPost()))
            Thread.sleep(100)
        }
        postList.reverse()
    }

    @Test
    fun getPostList(){
        val page = 1L
        val size = 8L
        val result = cbnuSoftwareJobHuntPostListService.getPostList(page, size)

        val totalPage=(postList.size+size-1)/size
        val nowListAmount= min(postList.size-page*size,size)
        Assertions.assertThat(result.data.size).isEqualTo(nowListAmount)
        Assertions.assertThat(result.pagination.totalPage).isEqualTo(totalPage)
        Assertions.assertThat(result.pagination.totalElement).isEqualTo(postList.size.toLong())
        Assertions.assertThat(result.pagination.currentPage).isEqualTo(page)
        Assertions.assertThat(result.pagination.elementSizeOfPage).isEqualTo(size)
    }
}