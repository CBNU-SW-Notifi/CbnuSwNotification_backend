package com.CbnuSwNotification.CbnuSwNotification.application.service.CbnuSoftwareJobHunt

import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postListRepository.CbnuSoftwareJobHuntPostListRepository
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PaginationResultResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostMetadataResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dto.common.Pagination
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CbnuSoftwareJobHuntPostListService(
    private val cbnuSoftwareJobHuntPostListRepository: CbnuSoftwareJobHuntPostListRepository,
) {
    fun getPostList(page: Long, size: Long): PaginationResultResponse<PostMetadataResponse> {
        val postList = cbnuSoftwareJobHuntPostListRepository.getPostList(page, size).map {
            postListDto ->
            PostMetadataResponse(
                postId = postListDto.id,
                title = postListDto.title,
                createTime = postListDto.createTime,
            )
        }
        val totalElement = cbnuSoftwareJobHuntPostListRepository.getAllPostAmount()

        return PaginationResultResponse(
            data = postList,
            pagination = Pagination(
                elementSizeOfPage = size,
                currentPage = page,
                totalPage = getTotalPage(totalElement, size),
                totalElement = totalElement,
            )
        )
    }

    private fun getTotalPage(totalElement: Long, size: Long): Long {
        return (totalElement + size - 1) / size
    }
}