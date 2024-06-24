package com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntAttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.QCbnuSoftwareJobHuntAttachedFileUrl.cbnuSoftwareJobHuntAttachedFileUrl
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbAttachedFileUrlRepository(
    private val em: EntityManager,
) : AttachedFileUrlRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)

    override fun save(cbnuSoftwareJobHuntAttachedFileUrl: CbnuSoftwareJobHuntAttachedFileUrl): Long {
        em.persist(cbnuSoftwareJobHuntAttachedFileUrl)
        return cbnuSoftwareJobHuntAttachedFileUrl.id!!
    }

    override fun findById(id: Long): CbnuSoftwareJobHuntAttachedFileUrl {
        return em.find(CbnuSoftwareJobHuntAttachedFileUrl::class.java, id)
    }

    override fun findAllByPost(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): List<CbnuSoftwareJobHuntAttachedFileUrl> {
        return querydsl
            .select(cbnuSoftwareJobHuntAttachedFileUrl)
            .from(cbnuSoftwareJobHuntAttachedFileUrl)
            .where(cbnuSoftwareJobHuntAttachedFileUrl.post.eq(cbnuSoftwareJobHuntPost))
            .fetch()
    }
}