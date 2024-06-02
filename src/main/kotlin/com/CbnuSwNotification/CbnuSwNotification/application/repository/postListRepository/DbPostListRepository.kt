package com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.QPost.post
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.dto.PostListDto
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbPostListRepository(
    private val em: EntityManager
) : PostListRepository{

    private val querydsl:JPAQueryFactory = JPAQueryFactory(em)

    override fun getPostList(page: Long, size: Long): List<PostListDto> {
        //TODO:쿼리 최적화 필요
        return querydsl
            .select(Projections.constructor(PostListDto::class.java,
                post.id,
                post.title,
                post.postType,
                post.createTime
            ))
            .from(post)
            .orderBy(post.createTime.desc())
            .offset(page*size)
            .limit(size)
            .fetch()
    }
}