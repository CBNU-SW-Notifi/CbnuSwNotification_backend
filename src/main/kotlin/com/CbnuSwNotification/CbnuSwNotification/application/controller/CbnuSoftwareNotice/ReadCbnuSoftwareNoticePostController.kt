package com.CbnuSwNotification.CbnuSwNotification.application.controller.CbnuSoftwareNotice

import com.CbnuSwNotification.CbnuSwNotification.application.service.CbnuSoftwareNotice.CbnuSoftwareNoticePostReadService
import com.CbnuSwNotification.CbnuSwNotification.common.dto.postReadDto.PostReadResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Notice Post API", description = "Notice API 목록")
@RestController
@RequestMapping("/api/v1/notice-post")
class ReadCbnuSoftwareNoticePostController(
    private val postReadService: CbnuSoftwareNoticePostReadService,
) {
    private val log=LoggerFactory.getLogger(ReadCbnuSoftwareNoticePostController::class.java)

    @Operation(summary = "학과 공지 게시글 본문 조회", description = "학과 공지 게시글의 본문을 조회합니다")
    @GetMapping("/read/{id}")
    fun getPostList(
        @PathVariable(name = "id", required = true) @Parameter(description = "본문을 확인하고자 하는 게시글의 id") postId: Long,
    ): ResponseEntity<PostReadResponse> {
        log.info("학과 공지 게시글 본문 조회 - ${postId}")
        val response = postReadService.readPost(postId) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok().body(response)
    }
}