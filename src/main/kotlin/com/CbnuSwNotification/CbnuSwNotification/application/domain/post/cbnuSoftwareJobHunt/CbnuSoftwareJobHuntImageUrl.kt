package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import jakarta.persistence.*

@Entity
class CbnuSoftwareJobHuntImageUrl {
    @Id
    @GeneratedValue
    @Column(name = "cbnuSoftware_JobHunt_image_url_id")
    val id: Long? = null

    @Lob
    val url: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnuSoftware_JobHunt_post_id", nullable = false)
    val post: CbnuSoftwareJobHuntPost

    constructor(url: String, post: CbnuSoftwareJobHuntPost) {
        this.url = url
        this.post = post
    }
}