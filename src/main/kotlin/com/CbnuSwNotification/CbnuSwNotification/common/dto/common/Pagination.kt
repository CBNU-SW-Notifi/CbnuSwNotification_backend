package com.CbnuSwNotification.CbnuSwNotification.common.dto.common

data class Pagination(
    val elementSizeOfPage: Long,
    val currentPage: Long,
    val totalPage: Long,
    val totalElement: Long,
)