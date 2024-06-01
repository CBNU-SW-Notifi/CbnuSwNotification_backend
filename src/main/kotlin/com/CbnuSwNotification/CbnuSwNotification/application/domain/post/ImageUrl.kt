package com.CbnuSwNotification.CbnuSwNotification.application.domain.post

import jakarta.persistence.*

@Entity
class ImageUrl {
    @Id
    @GeneratedValue
    @Column(name = "image_url_id")
    private val id: Long? = null

    private val url: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id", nullable = false)
    private val post: Post

    constructor(url: String, post: Post) {
        this.url = url
        this.post = post
    }
}