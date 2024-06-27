package com.CbnuSwNotification.CbnuSwNotification.test.repository

import com.CbnuSwNotification.CbnuSwNotification.SpringTestSetting
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postListRepository.CbnuSoftwareJobHuntPostListRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postRepository.CbnuSoftwareJobHuntPostRepository
import com.CbnuSwNotification.CbnuSwNotification.fixture.PostFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class CbnuSoftwareJobHuntPostListRepositoryTest(
    @Autowired private val cbnuSoftwareJobHuntPostListRepository: CbnuSoftwareJobHuntPostListRepository,
    @Autowired private val cbnuSoftwareJobHuntPostRepository: CbnuSoftwareJobHuntPostRepository,
) : SpringTestSetting() {

    val postList = mutableListOf<Long>()

    @BeforeEach
    fun before(){
        for(i in 1..10){
            postList.add(cbnuSoftwareJobHuntPostRepository.save(PostFixture.createPost()))
            Thread.sleep(100)
        }
        postList.reverse()
    }

    @Test
    fun paginationTest(){
        val page = 0L
        val size = 3L

        val postList1 = cbnuSoftwareJobHuntPostListRepository.getPostList(page, size)
        val postList2 = cbnuSoftwareJobHuntPostListRepository.getPostList(page+1, size)

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
        val amount = cbnuSoftwareJobHuntPostListRepository.getAllPostAmount()

        Assertions.assertThat(amount.toInt()).isEqualTo(postList.size)
    }
}