package com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository

import com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.dto.PostListDto

interface PostListRepository {

    /**
     * @param page: 몇 번째 페이지 인지
     * @param size: 한 페이지당 몇개인지
     * @return 해당 page에 있는 게시글
     */
    fun getPostList(page:Long, size:Long): List<PostListDto>
}