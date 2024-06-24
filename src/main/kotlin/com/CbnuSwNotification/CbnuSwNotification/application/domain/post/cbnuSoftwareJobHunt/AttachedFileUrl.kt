package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import jakarta.persistence.*

@Entity
class AttachedFileUrl {
    @Id
    @GeneratedValue
    @Column(name = "attached_file_url_id")
    val id: Long? = null

    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    val name: String

    @Lob
    val url: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable = false)
    val post: Post

    constructor(name: String, url: String, post: Post) {
        this.name = name
        this.url = url
        this.post = post
    }
}