package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.AttachedFileName
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import jakarta.persistence.*

@Entity
class CbnuSoftwareNoticeAttachedFileUrl(
    @Embedded
    val name: AttachedFileName,

    @Lob
    val url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnu_software_job_hunt_post_id", nullable = false)
    val post: CbnuSoftwareNoticePost,
) {
    @Id
    @GeneratedValue
    @Column(name = "cbnu_software_notice_attached_file_url_id")
    val id: Long? = null

}