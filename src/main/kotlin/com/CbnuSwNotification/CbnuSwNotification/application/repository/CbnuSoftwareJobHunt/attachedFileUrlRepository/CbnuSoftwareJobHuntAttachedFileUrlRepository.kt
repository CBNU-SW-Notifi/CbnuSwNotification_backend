package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.attachedFileUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntAttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost

interface CbnuSoftwareJobHuntAttachedFileUrlRepository {

    /**
     * @param cbnuSoftwareJobHuntAttachedFileUrl 첨부파일 url 객체
     * @return 저장된 객체의 id
     */
    fun save(cbnuSoftwareJobHuntAttachedFileUrl: CbnuSoftwareJobHuntAttachedFileUrl): Long

    /**
     * @param id 찾고싶은 AttachedFileUrl의 id
     * @return 찾고자한 AttachedFileUrl 객체
     */
    fun findById(id: Long): CbnuSoftwareJobHuntAttachedFileUrl

    /**
     * @param cbnuSoftwareJobHuntPost 첨부파일 리스트를 얻고자하는 POST객체
     * @return 해당 POST에 포함된 AttachedFileUrl리스트
     */
    fun findAllByPost(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): List<CbnuSoftwareJobHuntAttachedFileUrl>

}