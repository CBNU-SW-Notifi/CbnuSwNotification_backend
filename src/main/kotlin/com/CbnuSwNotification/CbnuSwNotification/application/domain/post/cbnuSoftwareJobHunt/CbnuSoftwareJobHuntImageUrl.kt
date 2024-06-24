package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import jakarta.persistence.*

@Entity
class CbnuSoftwareJobHuntImageUrl {
    @Id
    @GeneratedValue
    @Column(name = "cbnu_software_job_hunt_image_url_id")
    val id: Long? = null

    @Lob
    val url: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnu_software_job_hunt_post_id", nullable = false)
    val post: CbnuSoftwareJobHuntPost

    constructor(url: String, post: CbnuSoftwareJobHuntPost) {
        this.url = url
        this.post = post
    }
}