package com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.ImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.Post
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.QImageUrl.imageUrl
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbImageUrlRepository(
    private val em: EntityManager
): ImageUrlRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)
    override fun save(imageUrl: ImageUrl): Long {
        em.persist(imageUrl)
        return imageUrl.id!!
    }

    override fun findById(id: Long): ImageUrl {
        return em.find(ImageUrl::class.java, id)
    }

    override fun findAllByPost(post: Post): List<ImageUrl> {
        return querydsl
            .select(imageUrl)
            .from(imageUrl)
            .where(imageUrl.post.eq(post))
            .fetch()
    }
}