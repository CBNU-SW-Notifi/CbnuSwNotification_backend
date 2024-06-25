package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import jakarta.persistence.*

@Entity
class CbnuSoftwareJobHuntImageUrl(
    @Lob
    val url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnu_software_job_hunt_post_id", nullable = false)
    val post: CbnuSoftwareJobHuntPost,
) {
    @Id
    @GeneratedValue
    @Column(name = "cbnu_software_job_hunt_image_url_id")
    val id: Long? = null
}