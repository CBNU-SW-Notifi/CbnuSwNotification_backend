package com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost

import com.CbnuSwNotification.CbnuSwNotification.application.controller.informationPost.dto.PostReadResponse
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@Tag(name = "Information Post API", description = "Information Post  API 목록")
@Controller
@RestController
@RequestMapping("/api/v1/post")
class ReadPostController {

    private val log = LoggerFactory.getLogger(ReadPostController::class.java)

    @Operation(summary = "정보 게시글 본문 조회", description = "정보 게시글의 본문을 조회합니다")
    @GetMapping("/read/{id}")
    fun getPostList(
        @PathVariable(name = "id", required = true) @Parameter(description = "본문을 확인하고자 하는 게시글의 id") postId: Long,
    ): ResponseEntity<PostReadResponse> {
        log.info("정보 게시글 본문 조회 - ${postId}")

        val response = PostReadResponse(
            postId = 1,
            title = "tmp",
            content = "tmp",
            imageUrls = listOf(),
            attachedFiles = listOf(),
            postType = PostType.COMMON,
            createTime = LocalDateTime.now(),
        )
        return ResponseEntity.ok().body(response)
    }
}