package com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.AttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.Post

interface AttachedFileUrlRepository {

    /**
     * @param attachedFileUrl 첨부파일 url 객체
     * @return 저장된 객체의 id
     */
    fun save(attachedFileUrl: AttachedFileUrl): Long

    /**
     * @param id 찾고싶은 AttachedFileUrl의 id
     * @return 찾고자한 AttachedFileUrl 객체
     */
    fun findById(id: Long): AttachedFileUrl

    /**
     * @param post 첨부파일 리스트를 얻고자하는 POST객체
     * @return 해당 POST에 포함된 AttachedFileUrl리스트
     */
    fun findAllByPost(post: Post): List<AttachedFileUrl>

}