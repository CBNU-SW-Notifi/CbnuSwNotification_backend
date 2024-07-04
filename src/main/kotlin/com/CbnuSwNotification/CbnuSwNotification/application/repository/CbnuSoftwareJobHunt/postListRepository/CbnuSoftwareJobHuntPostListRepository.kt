package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postListRepository

import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostListDto

interface CbnuSoftwareJobHuntPostListRepository {

    /**
     * @param page: 몇 번째 페이지 인지
     * @param size: 한 페이지당 몇개인지
     * @return 해당 page에 있는 게시글
     */
    fun getPostList(page:Long, size:Long): List<PostListDto>

    /**
     * 모든 게시글의 개수를 반환
     * @return 게시글의 개수
     */
    fun getAllPostAmount(): Long
}