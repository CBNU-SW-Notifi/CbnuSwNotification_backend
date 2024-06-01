package com.CbnuSwNotification.CbnuSwNotification.application.domain.post

import jakarta.persistence.*
import lombok.Getter

@Entity
class AttachedFileUrl {
    @Id
    @GeneratedValue
    @Column(name = "attached_file_url_id")
    private val id: Long? = null

    private val name: String

    private val url: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable = false)
    private val post: Post

    constructor(name: String, url: String, post: Post) {
        this.name = name
        this.url = url
        this.post = post
    }
}