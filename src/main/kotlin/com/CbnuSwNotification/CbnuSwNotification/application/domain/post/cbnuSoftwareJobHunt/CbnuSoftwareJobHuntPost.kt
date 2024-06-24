package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
class CbnuSoftwareJobHuntPost(
    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    val title: String,
    @Column(columnDefinition = "VARCHAR(20000) CHARACTER SET UTF8")
    @Lob
    val content: String,
    @Enumerated(EnumType.STRING)
    val postType: PostType,
    val createTime: LocalDateTime,
) {
    @Id
    @GeneratedValue
    @Column(name = "cbnuSoftware_JobHunt_post_id")
    val id: Long? = null

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var saveTime: LocalDateTime? = null
        private set
}