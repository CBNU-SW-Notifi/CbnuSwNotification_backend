package com.CbnuSwNotification.CbnuSwNotification.application.controller.CbnuSoftwareNotice


import com.CbnuSwNotification.CbnuSwNotification.application.service.CbnuSoftwareNotice.CbnuSoftwareNoticePostListService
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PaginationResultResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostMetadataResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Notice Post API", description = "Notice Post  API 목록")
@RestController
@RequestMapping("/api/v1/notice-post")
class GetCbnuSoftwareNoticePostListController(
    private val cbnuSoftwareNoticePostListService: CbnuSoftwareNoticePostListService,
) {

    private val log = LoggerFactory.getLogger(GetCbnuSoftwareNoticePostListController::class.java)

    @Operation(summary = "학과 공지 게시글 리스트 조회", description = "학과 공지 게시글의 리스트 조회를 조회합니다")
    @GetMapping("/list")
    fun getPostList(
        @RequestParam(defaultValue = "0")@Parameter(description = "현재 페이지") page: Long,
        @RequestParam(defaultValue = "7")@Parameter(description = "받아올 개수") size: Long,
    ): ResponseEntity<PaginationResultResponse<PostMetadataResponse>> {
        log.info("학과 공지 게시글 리스트 조회 - page: $page, size: $size")
        val result = cbnuSoftwareNoticePostListService.getPostList(page, size)

        return ResponseEntity.ok().body(result)
    }
}