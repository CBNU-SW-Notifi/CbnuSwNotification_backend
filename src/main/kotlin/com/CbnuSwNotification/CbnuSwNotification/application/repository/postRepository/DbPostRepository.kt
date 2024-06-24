package com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbPostRepository(
    private val em: EntityManager
) : PostRepository {
    override fun save(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): Long {
        em.persist(cbnuSoftwareJobHuntPost)
        return cbnuSoftwareJobHuntPost.id!!
    }

    override fun findById(id: Long): CbnuSoftwareJobHuntPost? {
        return em.find(CbnuSoftwareJobHuntPost::class.java, id)
    }
}