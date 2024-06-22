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
    override fun save(token: Token) {
        em.persist(em)
    }

    override fun getAllDeviceToken(): List<String> {
        return querydsl
            .select(token1.token.token)
            .from(token1)
            .fetch()
    }

    override fun updateTokenByAndroidId(androidId: String, token: String) {
        var oldToken = em.find(Token::class.java, androidId)

        if(oldToken==null){
            oldToken= Token(
                id = DeviceId(androidId),
                token = DeviceToken(token),
            )
            save(oldToken)
        }
        else{
            oldToken.token = DeviceToken(token)
        }
    }
}