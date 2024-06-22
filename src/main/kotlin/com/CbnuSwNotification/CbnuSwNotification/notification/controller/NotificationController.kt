package com.CbnuSwNotification.CbnuSwNotification.notification.controller

import com.CbnuSwNotification.CbnuSwNotification.notification.controller.dto.NotificationRequest
import com.CbnuSwNotification.CbnuSwNotification.notification.service.NotificationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Notification API", description = "Notification  API 목록")
@RestController
@RequestMapping("/api/v1/notification")
class NotificationController(
    private val notificationService: NotificationService,
) {

    private val log = LoggerFactory.getLogger(NotificationController::class.java)

    @Operation(summary = "전체에게 메시지 보내기", description = "토큰이 저장되어 있는 모든 사용자에게 알림을 보냅니다.")
    @GetMapping("/sendToAll")
    fun sendNotificationToAll(@RequestBody notificationRequest: NotificationRequest){
        log.info("전체에게 알림 발송 요청")
        notificationService.sendMessageToAllUser(
            title = notificationRequest.title,
            body = notificationRequest.body,
        )
    }
}