package com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto

import com.CbnuSwNotification.CbnuSwNotification.common.dto.common.Pagination

data class PaginationResultResponse<T>(
    val data: List<T>,
    val pagination: Pagination
)
