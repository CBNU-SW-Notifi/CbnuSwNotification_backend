package com.CbnuSwNotification.CbnuSwNotification.application.service

import com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.PostListRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.dto.PostListDto
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PaginationResultResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostMetadataResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dto.common.Pagination
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PostListService(
    private val postListRepository: PostListRepository,
) {
    fun getPostList(page: Long, size: Long): PaginationResultResponse<PostListDto> {
        val postList = postListRepository.getPostList(page, size)
        val totalElement = postListRepository.getAllPostAmount()

        return PaginationResultResponse(
            data = postList,
            pagination = Pagination(
                elementSizeOfPage = size,
                currentPage = page,
                totalPage = (totalElement+size-1)/size,
                totalElement = totalElement,
            )
        )
    }
}