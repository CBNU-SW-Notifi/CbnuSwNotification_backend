package com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Lob

/**
 * 충북대 소프트웨어 학과 크롤링 로그
 */
@Entity
class CbnuSoftwareCrawlingLastIndex(
    @Lob
    val url: String,
    val lastNum: Long,
) {
    @Id
    @GeneratedValue
    @Column(name = "image_url_id")
    val id: Long? = null
}