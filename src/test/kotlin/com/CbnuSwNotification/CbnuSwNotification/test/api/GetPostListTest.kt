package com.CbnuSwNotification.CbnuSwNotification.test.api

import com.CbnuSwNotification.CbnuSwNotification.ApiTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


class GetPostListTest(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val mockMvc: MockMvc,
) : ApiTestSetting() {

    val postList = mutableListOf<Long>()
    var objectMapper = ObjectMapper()

    @BeforeEach
    fun before() {
        for (i in 1..10) {
            postList.add(postRepository.save(PostFixture.createPost()))
            Thread.sleep(10)
        }
        postList.reverse()
    }

    @Test
    fun getPostListTest() {
        val page = 1L
        val size = 8L
        val response = mockMvc.perform(
            MockMvcRequestBuilders
                .get("/api/v1/information-post/list?page=$page&size=$size")
        )

        response.andExpect(MockMvcResultMatchers.status().isOk)
    }
}