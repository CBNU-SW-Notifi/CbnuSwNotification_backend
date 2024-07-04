package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.postRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticePost
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbCbnuSoftwareNoticePostRepository(
    private val em: EntityManager
):CbnuSoftwareNoticePostRepository {
    override fun save(post: CbnuSoftwareNoticePost): Long {
        em.persist(post)
        return post.id!!
    }

    override fun findById(id: Long): CbnuSoftwareNoticePost? {
        return em.find(CbnuSoftwareNoticePost::class.java, id)
    }
}