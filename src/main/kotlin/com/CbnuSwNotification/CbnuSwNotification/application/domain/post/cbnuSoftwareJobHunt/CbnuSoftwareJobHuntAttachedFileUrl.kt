package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import jakarta.persistence.*

@Entity
class CbnuSoftwareJobHuntAttachedFileUrl {
    @Id
    @GeneratedValue
    @Column(name = "cbnuSoftware_JobHunt_attached_file_url_id")
    val id: Long? = null

    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    val name: String

    @Lob
    val url: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnuSoftware_JobHunt_post_id", nullable = false)
    val post: CbnuSoftwareJobHuntPost

    constructor(name: String, url: String, post: CbnuSoftwareJobHuntPost) {
        this.name = name
        this.url = url
        this.post = post
    }
}