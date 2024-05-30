package com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost

import com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost.dto.CursorResultResponse
import com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost.dto.PostMetadataResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
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
class GetPostListController {

    private val log = LoggerFactory.getLogger(GetPostListController::class.java)

    @Operation(summary = "정보 게시글 리스트 조회", description = "정보 게시글의 리스트 조회를 조회합니다")
    @GetMapping("/list")
    fun getPostList(
        @RequestParam(defaultValue = "0")@Parameter(description = "마지막으로 받아온 post의 id") cursor: Long,
        @RequestParam(defaultValue = "7")@Parameter(description = "받아올 개수") size: Long,
    ): ResponseEntity<CursorResultResponse<PostMetadataResponse>> {
        log.info("게시글 리스트 조회 - cursor: ${cursor}, size: ${size}")

        return ResponseEntity.ok().body(CursorResultResponse(
            value = listOf(PostMetadataResponse(1,"tmp",PostType.COMMON, LocalDateTime.now())),
            hasNext = false,
            lastIndex = 1,
        ))
    }
}