package com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.repository

import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.CrawlingLastIndex
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.QCbnuSoftwareCrawlingLastIndex.cbnuSoftwareCrawlingLastIndex
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class DbCrawlingLastIndexRepository(
    private val em: EntityManager
) : CrawlingLastIndexRepository {

    private val querydsl: JPAQueryFactory = JPAQueryFactory(em)
    override fun save(crawlingLastIndex: CrawlingLastIndex): Long {
        em.persist(crawlingLastIndex)
        return crawlingLastIndex.id!!
    }

    override fun findByUrl(url: String): CrawlingLastIndex? {
        return querydsl
            .select(cbnuSoftwareCrawlingLastIndex)
            .from(cbnuSoftwareCrawlingLastIndex)
            .where(cbnuSoftwareCrawlingLastIndex.url.eq(url))
            .fetchOne()
    }


}