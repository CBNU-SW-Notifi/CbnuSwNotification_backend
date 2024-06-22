package com.CbnuSwNotification.CbnuSwNotification.notification.controller

import com.CbnuSwNotification.CbnuSwNotification.notification.controller.dto.NotificationRequest
import com.CbnuSwNotification.CbnuSwNotification.notification.controller.dto.TokenUpdateRequest
import com.CbnuSwNotification.CbnuSwNotification.notification.service.NotificationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Notification API", description = "Notification  API 목록")
@RestController
@RequestMapping("/api/v1/notification")
class NotificationController(
    private val notificationService: NotificationService,
) {

    private val log = LoggerFactory.getLogger(NotificationController::class.java)

    @Operation(summary = "전체에게 알림 보내기", description = "토큰이 저장되어 있는 모든 사용자에게 알림을 보냅니다.")
    @PostMapping("/sendToAll")
    fun sendNotificationToAll(@RequestBody @Valid notificationRequest: NotificationRequest)
            : ResponseEntity<Void> {
        log.info("전체에게 알림 발송 요청")
        notificationService.sendMessageToAllUser(
            title = notificationRequest.title,
            body = notificationRequest.body,
        )
         return ResponseEntity.ok().build()
    }

    @Operation(summary = "토큰 저장", description = "토큰을 저장, 이미 토큰을 가진 id일 경우 덮어씀")
    @PutMapping("/saveToken")
    fun saveToken(@RequestBody @Valid tokenUpdateRequest: TokenUpdateRequest)
            : ResponseEntity<Void>{
        log.info("${tokenUpdateRequest.id}의 토큰 저장")
        notificationService.updateToken(
            id = tokenUpdateRequest.id,
            token = tokenUpdateRequest.token,
        )
        return ResponseEntity.ok().build()
    }
}