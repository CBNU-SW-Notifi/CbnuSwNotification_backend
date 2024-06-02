package com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository

import com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.dto.PostListDto

interface PostListRepository {

    /**
     * @param cursor: 어디 이후로 부터 조회할지
     * @param size: 몇개를 반환할지
     * @return cursor 위치 이후 부터 size개
     */
    fun getPostList(cursor:Long,size:Long): List<PostListDto>
}