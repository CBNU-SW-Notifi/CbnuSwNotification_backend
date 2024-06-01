package com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbPostRepository(
    private val em: EntityManager
) : PostRepository {
    override fun save(post: Post): Long {
        em.persist(post)
        return post.id!!
    }

    override fun findById(id: Long): Post? {
        return em.find(Post::class.java, id)
    }
}