package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.imageUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticeImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticePost


interface CbnuSoftwareNoticeImageUrlRepository {
    /**
     * @param imageUrl CbnuSoftwareNotice의 이미지 url 객체
     * @return 저장된 객체의 id
     */
    fun save(imageUrl: CbnuSoftwareNoticeImageUrl): Long

    /**
     * @param id CbnuSoftwareNotice의 imageUrl의 id
     * @return CbnuSoftwareNotice의 imageUrl 객체
     */
    fun findById(id: Long): CbnuSoftwareNoticeImageUrl

    /**
     * @param post 사진을 얻고자하는 CbnuSoftwareNotice의 post객체
     * @return 해당 post의 imageUrl리스트
     */
    fun findAllByPost(post: CbnuSoftwareNoticePost): List<CbnuSoftwareNoticeImageUrl>
}