package com.CbnuSwNotification.CbnuSwNotification.notification.token.repository

import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.QToken.token1
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.Token
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceId
import com.CbnuSwNotification.CbnuSwNotification.notification.token.domain.valueObject.DeviceToken
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbTokenRepository(
    private val em: EntityManager,
):TokenRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)
    override fun save(token: Token){
        em.persist(token)
    }

    override fun getAllDeviceToken(): List<String> {
        return querydsl
            .select(token1.token.token)
            .from(token1)
            .fetch()
    }

    override fun updateTokenByAndroidId(deviceId: String, token: String) {
        var oldToken = findTokenByDeviceId(deviceId)


        if(oldToken==null){
            oldToken= Token(
                deviceId = DeviceId(deviceId),
                token = DeviceToken(token),
            )
            save(oldToken)
        }
        else{
            oldToken.token = DeviceToken(token)
        }
    }

    private fun findTokenByDeviceId(id: String): Token? {
        return querydsl
            .select(token1)
            .from(token1)
            .where(token1.deviceId.deviceId.eq(id))
            .fetchOne()
    }
}