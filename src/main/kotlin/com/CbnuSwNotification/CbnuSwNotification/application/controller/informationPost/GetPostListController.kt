package com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost

import com.CbnuSwNotification.CbnuSwNotification.application.service.PostListService
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PaginationResultResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostMetadataResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import com.CbnuSwNotification.CbnuSwNotification.common.dto.common.Pagination
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@Tag(name = "Information Post API", description = "Information Post  API 목록")
@RestController
@RequestMapping("/api/v1/information-post")
class GetPostListController(
    private val postListService: PostListService,
) {

    private val log = LoggerFactory.getLogger(GetPostListController::class.java)

    @Operation(summary = "정보 게시글 리스트 조회", description = "정보 게시글의 리스트 조회를 조회합니다")
    @GetMapping("/list")
    fun getPostList(
        @RequestParam(defaultValue = "0")@Parameter(description = "현재 페이지") page: Long,
        @RequestParam(defaultValue = "7")@Parameter(description = "받아올 개수") size: Long,
    ): ResponseEntity<PaginationResultResponse<PostMetadataResponse>> {
        log.info("게시글 리스트 조회 - page: $page, size: $size")
        val result = postListService.getPostList(page, size)

        return ResponseEntity.ok().body(result)
    }
}