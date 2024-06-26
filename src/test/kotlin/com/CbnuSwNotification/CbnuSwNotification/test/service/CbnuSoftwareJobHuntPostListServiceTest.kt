package com.CbnuSwNotification.CbnuSwNotification.test.service

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.application.service.PostListService
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import kotlin.math.min

class CbnuSoftwareJobHuntPostListServiceTest(
    @Autowired private val postListService: PostListService,
    @Autowired private val postRepository: PostRepository,
) : SpringTestSetting() {

    val postList = mutableListOf<Long>()
    @BeforeEach
    fun before() {
        for (i in 1..10) {
            postList.add(postRepository.save(PostFixture.createPost()))
            Thread.sleep(100)
        }
        postList.reverse()
    }

    @Test
    fun getPostList(){
        val page = 1L
        val size = 8L
        val result = postListService.getPostList(page, size)

        val totalPage=(postList.size+size-1)/size
        val nowListAmount= min(postList.size-page*size,size)
        Assertions.assertThat(result.data.size).isEqualTo(nowListAmount)
        Assertions.assertThat(result.pagination.totalPage).isEqualTo(totalPage)
        Assertions.assertThat(result.pagination.totalElement).isEqualTo(postList.size.toLong())
        Assertions.assertThat(result.pagination.currentPage).isEqualTo(page)
        Assertions.assertThat(result.pagination.elementSizeOfPage).isEqualTo(size)
    }
}