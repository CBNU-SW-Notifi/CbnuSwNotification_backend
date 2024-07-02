package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.imageUrlRepository


import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticeImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticePost
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.QCbnuSoftwareNoticeImageUrl.cbnuSoftwareNoticeImageUrl
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager

class DbCbnuSoftwareNoticeImageUrlRepository(
    private val em: EntityManager
): CbnuSoftwareNoticeImageUrlRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)
    override fun save(imageUrl: CbnuSoftwareNoticeImageUrl): Long {
        em.persist(imageUrl)
        return imageUrl.id!!
    }

    override fun findById(id: Long): CbnuSoftwareNoticeImageUrl {
        return em.find(CbnuSoftwareNoticeImageUrl::class.java, id)
    }

    override fun findAllByPost(post: CbnuSoftwareNoticePost): List<CbnuSoftwareNoticeImageUrl> {
        return querydsl
            .select(cbnuSoftwareNoticeImageUrl)
            .from(cbnuSoftwareNoticeImageUrl)
            .where(cbnuSoftwareNoticeImageUrl.post.eq(post))
            .fetch()
    }
}