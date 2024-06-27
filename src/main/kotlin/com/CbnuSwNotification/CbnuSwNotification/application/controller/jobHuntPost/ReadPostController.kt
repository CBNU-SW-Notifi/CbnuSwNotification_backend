package com.CbnuSwNotification.CbnuSwNotification.application.controller.jobHuntPost

import com.CbnuSwNotification.CbnuSwNotification.application.service.CbnuSoftwareJobHuntPostReadService
import com.CbnuSwNotification.CbnuSwNotification.common.dto.postReadDto.PostReadResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "job hunt Post API", description = "job hunt Post API 목록")
@RestController
@RequestMapping("/api/v1/job-hunt-post")
class ReadPostController(
    private val cbnuSoftwareJobHuntPostReadService: CbnuSoftwareJobHuntPostReadService,
) {

    private val log = LoggerFactory.getLogger(ReadPostController::class.java)

    @Operation(summary = "취업 정보 게시글 본문 조회", description = "취업 정보 게시글의 본문을 조회합니다")
    @GetMapping("/read/{id}")
    fun getPostList(
        @PathVariable(name = "id", required = true) @Parameter(description = "본문을 확인하고자 하는 게시글의 id") postId: Long,
    ): ResponseEntity<PostReadResponse> {
        log.info("취업 정보 게시글 본문 조회 - ${postId}")
        val response = cbnuSoftwareJobHuntPostReadService.readPost(postId) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok().body(response)
    }
}