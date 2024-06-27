package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postListRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.QCbnuSoftwareJobHuntPost.cbnuSoftwareJobHuntPost
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postListRepository.dto.PostListDto
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbCbnuSoftwareJobHuntPostListRepository(
    private val em: EntityManager
) : CbnuSoftwareJobHuntPostListRepository {

    private val querydsl:JPAQueryFactory = JPAQueryFactory(em)

    override fun getPostList(page: Long, size: Long): List<PostListDto> {
        //TODO:쿼리 최적화 필요
        return querydsl
            .select(Projections.constructor(
                PostListDto::class.java,
                cbnuSoftwareJobHuntPost.id,
                cbnuSoftwareJobHuntPost.title.title,
                cbnuSoftwareJobHuntPost.createTime
            ))
            .from(cbnuSoftwareJobHuntPost)
            .orderBy(cbnuSoftwareJobHuntPost.createTime.desc(), cbnuSoftwareJobHuntPost.id.asc())
            .offset(page*size)
            .limit(size)
            .fetch()
    }

    override fun getAllPostAmount(): Long {
        return querydsl.select(cbnuSoftwareJobHuntPost.count())
            .from(cbnuSoftwareJobHuntPost)
            .fetchFirst() ?: 0L
    }
}