package com.CbnuSwNotification.CbnuSwNotification.test.repository

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.PostListRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CbnuSoftwareJobHuntPostListRepositoryTest(
    @Autowired private val postListRepository: PostListRepository,
    @Autowired private val postRepository: PostRepository,
) : SpringTestSetting() {

    val postList = mutableListOf<Long>()

    @BeforeEach
    fun before(){
        for(i in 1..10){
            postList.add(postRepository.save(PostFixture.createPost()))
            Thread.sleep(100)
        }
        postList.reverse()
    }

    @Test
    fun paginationTest(){
        val page = 0L
        val size = 3L

        val postList1 = postListRepository.getPostList(page, size)
        val postList2 = postListRepository.getPostList(page+1, size)

        Assertions.assertThat(postList1.size).isEqualTo(size)
        for (i in 0 ..< size){
            Assertions.assertThat(postList1[i.toInt()].id).isEqualTo(postList[i.toInt()])
        }

        Assertions.assertThat(postList2.size).isEqualTo(size)
        for (i in 0 ..< size){
            Assertions.assertThat(postList2[i.toInt()].id).isEqualTo(postList[(i+size).toInt()])
        }
    }



    @Test
    fun postAmountTest(){
        val amount = postListRepository.getAllPostAmount()

        Assertions.assertThat(amount.toInt()).isEqualTo(postList.size)
    }
}