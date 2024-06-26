package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.imageUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

interface ImageUrlRepository {

    /**
     * @param cbnuSoftwareJobHuntImageUrl 이미지 url 객체
     * @return 저장된 객체의 id
     */
    fun save(cbnuSoftwareJobHuntImageUrl: CbnuSoftwareJobHuntImageUrl): Long

    /**
     * @param id imageUrl의 id
     * @return imageUrl 객체
     */
    fun findById(id: Long): CbnuSoftwareJobHuntImageUrl

    /**
     * @param cbnuSoftwareJobHuntPost 사진을 얻고자하는 post객체
     * @return 해당 post의 imageUrl리스트
     */
    fun findAllByPost(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): List<CbnuSoftwareJobHuntImageUrl>

}