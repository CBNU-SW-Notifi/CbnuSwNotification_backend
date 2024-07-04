package com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareNotice.attachedFileUrlRepository

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticeAttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice.CbnuSoftwareNoticePost

interface CbnuSoftwareNoticeAttachedFileUrlRepository {
    /**
     * @param attachedFileUrl 첨부파일 url 객체
     * @return 저장된 객체의 id
     */
    fun save(attachedFileUrl: CbnuSoftwareNoticeAttachedFileUrl): Long

    /**
     * @param id 찾고싶은 CbnuSoftwareNoticeAttachedFileUrl의 id
     * @return 찾고자한 CbnuSoftwareNoticeAttachedFileUrl 객체
     */
    fun findById(id: Long): CbnuSoftwareNoticeAttachedFileUrl

    /**
     * @param post 첨부파일 리스트를 얻고자하는 CbnuSoftwareNoticePost객체
     * @return 해당 CbnuSoftwareNoticePost에 포함된 CbnuSoftwareNoticeAttachedFileUrl리스트
     */
    fun findAllByPost(post: CbnuSoftwareNoticePost): List<CbnuSoftwareNoticeAttachedFileUrl>
}