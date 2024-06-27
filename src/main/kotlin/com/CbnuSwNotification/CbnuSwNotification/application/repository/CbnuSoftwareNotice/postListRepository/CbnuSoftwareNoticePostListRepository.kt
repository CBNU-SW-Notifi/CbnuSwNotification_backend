package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.postListRepository

import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostListDto


interface CbnuSoftwareNoticePostListRepository {

    /**
     * @param page: 몇 번째 페이지 인지
     * @param size: 한 페이지당 몇개인지
     * @return 해당 page에 있는 CbnuSoftwareNotice의 게시글
     */
    fun getPostList(page:Long, size:Long): List<PostListDto>

    /**
     * 모든 CbnuSoftwareNotice의 게시글 개수를 반환
     * @return 게시글의 개수
     */
    fun getAllPostAmount(): Long
}