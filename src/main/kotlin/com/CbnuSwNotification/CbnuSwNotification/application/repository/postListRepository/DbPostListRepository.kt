package com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.QPost.post
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postListRepository.dto.PostListDto
import com.querydsl.core.types.ExpressionUtils.and
import com.querydsl.core.types.ExpressionUtils.count
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.Wildcard.count
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
            .orderBy(post.createTime.desc(), post.id.asc())
            .offset(page*size)
            .limit(size)
            .fetch()
    }

    override fun getAllPostAmount(): Long {
        return querydsl.select(post.count())
            .from(post)
            .fetchFirst() ?: 0L
    }
}