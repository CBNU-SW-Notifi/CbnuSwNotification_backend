package com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.repository

import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.CrawlingLastIndex
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.QCrawlingLastIndex.crawlingLastIndex
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
            .select(crawlingLastIndex)
            .from(crawlingLastIndex)
            .where(crawlingLastIndex.url.eq(url))
            .fetchOne()
    }


}