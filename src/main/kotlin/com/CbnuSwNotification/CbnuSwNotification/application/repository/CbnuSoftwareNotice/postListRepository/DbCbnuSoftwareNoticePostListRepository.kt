package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.postListRepository


import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.QCbnuSoftwareNoticePost.cbnuSoftwareNoticePost
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postListRepository.CbnuSoftwareJobHuntPostListRepository
import com.CbnuSwNotification.CbnuSwNotification.common.dto.PostListDto.PostListDto
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbCbnuSoftwareNoticePostListRepository (
    private val em: EntityManager
) : CbnuSoftwareNoticePostListRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)
    override fun getPostList(page: Long, size: Long): List<PostListDto> {
        return querydsl
            .select(Projections.constructor(
                PostListDto::class.java,
                cbnuSoftwareNoticePost.id,
                cbnuSoftwareNoticePost.title.title,
                cbnuSoftwareNoticePost.createTime
            ))
            .from(cbnuSoftwareNoticePost)
            .orderBy(cbnuSoftwareNoticePost.createTime.desc(), cbnuSoftwareNoticePost.id.asc())
            .offset(page*size)
            .limit(size)
            .fetch()
    }

    override fun getAllPostAmount(): Long {
        return querydsl.select(cbnuSoftwareNoticePost.count())
            .from(cbnuSoftwareNoticePost)
            .fetchFirst() ?: 0L
    }
}