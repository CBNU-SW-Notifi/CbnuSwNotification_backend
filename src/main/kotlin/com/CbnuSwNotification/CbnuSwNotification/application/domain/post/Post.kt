package com.CbnuSwNotification.CbnuSwNotification.application.domain.post

import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import jakarta.persistence.*
import lombok.Getter
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
class Post(
    val title: String,
    val content: String,
    @Enumerated(EnumType.STRING)
    val postType: PostType,
    val createTime: LocalDateTime,
) {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    val id: Long? = null

    @CreatedDate
    @Column(nullable = false, updatable = false)
    val saveTime: LocalDateTime? = null
}