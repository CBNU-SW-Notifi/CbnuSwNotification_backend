package com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.repository

import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.CbnuSoftwareCrawlingLastIndex
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.QCbnuSoftwareCrawlingLastIndex
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.QCbnuSoftwareCrawlingLastIndex.cbnuSoftwareCrawlingLastIndex
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbJobHuntCrawlingLastIndexRepository(
    private val em: EntityManager
) : JobHuntCrawlingLastIndexRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)
    override fun save(cbnuSoftwareCrawlingLastIndex: CbnuSoftwareCrawlingLastIndex): Long {
        em.persist(cbnuSoftwareCrawlingLastIndex)
        return cbnuSoftwareCrawlingLastIndex.id!!
    }

    override fun findByUrl(url: String): CbnuSoftwareCrawlingLastIndex? {
        return querydsl
            .select(cbnuSoftwareCrawlingLastIndex)
            .from(cbnuSoftwareCrawlingLastIndex)
            .where(cbnuSoftwareCrawlingLastIndex.url.eq(url))
            .fetchOne()
    }


}