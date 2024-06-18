package com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.repository

import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.CbnuSoftwareCrawlingLastIndex

interface JobHuntCrawlingLastIndexRepository {
    fun save(cbnuSoftwareCrawlingLastIndex: CbnuSoftwareCrawlingLastIndex) :Long

    /**
     * 마지막 크롤링 로그를 반환
     * @param url 크롤링 대상인 url
     * @return 해당 url에서 크롤링한 마지막 index 또는 number
     */
    fun findLastLog(url: String): CbnuSoftwareCrawlingLastIndex

}