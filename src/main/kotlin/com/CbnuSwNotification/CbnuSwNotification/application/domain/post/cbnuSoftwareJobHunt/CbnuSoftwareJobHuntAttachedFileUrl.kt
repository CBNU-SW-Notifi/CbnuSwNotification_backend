package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import jakarta.persistence.*

@Entity
class CbnuSoftwareJobHuntAttachedFileUrl {
    @Id
    @GeneratedValue
    @Column(name = "cbnu_software_job_hunt_attached_file_url_id")
    val id: Long? = null

    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    val name: String

    @Lob
    val url: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnu_software_job_hunt_post_id", nullable = false)
    val post: CbnuSoftwareJobHuntPost

    constructor(name: String, url: String, post: CbnuSoftwareJobHuntPost) {
        this.name = name
        this.url = url
        this.post = post
    }
}