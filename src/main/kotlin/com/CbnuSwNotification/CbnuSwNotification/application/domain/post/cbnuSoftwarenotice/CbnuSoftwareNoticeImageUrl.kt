package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import jakarta.persistence.*

@Entity
class CbnuSoftwareNoticeImageUrl(
    @Lob
    val url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnu_software_notice_post_id", nullable = false)
    val post: CbnuSoftwareNoticePost,
) {
    @Id
    @GeneratedValue
    @Column(name = "cbnu_software_notice_image_url_id")
    val id: Long? = null
}