package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwarenotice

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostContent
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostTitle
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
class CbnuSoftwareNoticePost(
    @Embedded
    val title: PostTitle,
    @Embedded
    val content: PostContent,
    val createTime: LocalDateTime,
) {
    @Id
    @GeneratedValue
    @Column(name = "cbnu_software_notice_post_id")
    val id: Long? = null

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var saveTime: LocalDateTime? = null
        private set
}