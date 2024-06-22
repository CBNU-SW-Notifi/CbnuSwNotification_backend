package com.CbnuSwNotification.CbnuSwNotification.notification.token.repository

import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.Token


interface TokenRepository {
    fun save(token: Token)

    /**
     * 저장되어 있는 모든 토큰을 가져옴
     * @return 저장되어있는 모든 Token 객체가 가진 디바이스 토큰 값
     */
    fun getAllDeviceToken(): List<String>

    /**
     * androidId를 키로 가진 Token 객체의 디바이스 토큰값 업데이트, 만약 없을 경우 생성후 저장
     * @param androidId 토근을 업데이트 하고 싶은 androidId
     * @param token 업데이트할 토큰 값
     */
    fun updateTokenByAndroidId(androidId: String, token: String)

}