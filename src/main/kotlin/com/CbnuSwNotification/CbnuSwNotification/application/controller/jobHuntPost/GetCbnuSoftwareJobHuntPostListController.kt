package com.CbnuSwNotification.CbnuSwNotification.application.controller.jobHuntPost

import com.CbnuSwNotification.CbnuSwNotification.application.service.CbnuSoftwareJobHunt.CbnuSoftwareJobHuntPostListService
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PaginationResultResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostMetadataResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "job hunt Post API", description = "job hunt Post  API 목록")
@RestController
@RequestMapping("/api/v1/job-hunt-post")
class GetCbnuSoftwareJobHuntPostListController(
    private val cbnuSoftwareJobHuntPostListService: CbnuSoftwareJobHuntPostListService,
) {

    private val log = LoggerFactory.getLogger(GetCbnuSoftwareJobHuntPostListController::class.java)

    @Operation(summary = "취업 정보 게시글 리스트 조회", description = "취업 정보 게시글의 리스트 조회를 조회합니다")
    @GetMapping("/list")
    fun getPostList(
        @RequestParam(defaultValue = "0")@Parameter(description = "현재 페이지") page: Long,
        @RequestParam(defaultValue = "7")@Parameter(description = "받아올 개수") size: Long,
    ): ResponseEntity<PaginationResultResponse<PostMetadataResponse>> {
        log.info("취업 정보 게시글 리스트 조회 - page: $page, size: $size")
        val result = cbnuSoftwareJobHuntPostListService.getPostList(page, size)

        return ResponseEntity.ok().body(result)
    }
}