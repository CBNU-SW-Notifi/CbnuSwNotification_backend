package com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Lob

/**
 * 해당 url의 마지막 크롤링 대상을 저장하기 위한 도메인
 */
@Entity
class CrawlingLastIndex(
    /**
     * 크롤링 대상 페이지 주소
     */
    @Lob
    val url: String,
    @Lob
    /**
     * 해당 페이지에서 크롤링한 마지막 정보에 대한 내용
     * 어떤 내용이든 들어갈 수 있도록 string으로 제작
     * 크롤링시 추가적인 처리를 하여 사용
     */
    val lastIndex: String,
) {
    @Id
    @GeneratedValue
    @Column(name = "image_url_id")
    val id: Long? = null
}