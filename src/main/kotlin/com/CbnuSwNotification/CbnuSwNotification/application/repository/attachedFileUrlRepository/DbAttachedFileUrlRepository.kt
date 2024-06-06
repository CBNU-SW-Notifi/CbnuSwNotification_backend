package com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.AttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.QAttachedFileUrl.attachedFileUrl
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbAttachedFileUrlRepository(
    private val em: EntityManager,
) : AttachedFileUrlRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)

    override fun save(attachedFileUrl: AttachedFileUrl): Long {
        em.persist(attachedFileUrl)
        return attachedFileUrl.id!!
    }

    override fun findById(id: Long): AttachedFileUrl {
        return em.find(AttachedFileUrl::class.java, id)
    }

    override fun findAllByPost(post: Post): List<AttachedFileUrl> {
        return querydsl
            .select(attachedFileUrl)
            .from(attachedFileUrl)
            .where(attachedFileUrl.post.eq(post))
            .fetch()
    }
}