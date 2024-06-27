package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.attachedFileUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticeAttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticePost
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.QCbnuSoftwareNoticeAttachedFileUrl.cbnuSoftwareNoticeAttachedFileUrl
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager

class DbCbnuSoftwareNoticeAttachedFileUrlRepository(
    private val em: EntityManager,
): CbnuSoftwareNoticeAttachedFileUrlRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)

    override fun save(attachedFileUrl: CbnuSoftwareNoticeAttachedFileUrl): Long {
        em.persist(attachedFileUrl)
        return attachedFileUrl.id!!
    }

    override fun findById(id: Long): CbnuSoftwareNoticeAttachedFileUrl {
        return em.find(CbnuSoftwareNoticeAttachedFileUrl::class.java, id)
    }

    override fun findAllByPost(post: CbnuSoftwareNoticePost): List<CbnuSoftwareNoticeAttachedFileUrl> {
        return querydsl
            .select(cbnuSoftwareNoticeAttachedFileUrl)
            .from(cbnuSoftwareNoticeAttachedFileUrl)
            .where(cbnuSoftwareNoticeAttachedFileUrl.post.eq(post))
            .fetch()
    }
}