package com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.QCbnuSoftwareJobHuntImageUrl.cbnuSoftwareJobHuntImageUrl
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbImageUrlRepository(
    private val em: EntityManager
): ImageUrlRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)
    override fun save(cbnuSoftwareJobHuntImageUrl: CbnuSoftwareJobHuntImageUrl): Long {
        em.persist(cbnuSoftwareJobHuntImageUrl)
        return cbnuSoftwareJobHuntImageUrl.id!!
    }

    override fun findById(id: Long): CbnuSoftwareJobHuntImageUrl {
        return em.find(CbnuSoftwareJobHuntImageUrl::class.java, id)
    }

    override fun findAllByPost(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): List<CbnuSoftwareJobHuntImageUrl> {
        return querydsl
            .select(cbnuSoftwareJobHuntImageUrl)
            .from(cbnuSoftwareJobHuntImageUrl)
            .where(cbnuSoftwareJobHuntImageUrl.post.eq(cbnuSoftwareJobHuntPost))
            .fetch()
    }
}