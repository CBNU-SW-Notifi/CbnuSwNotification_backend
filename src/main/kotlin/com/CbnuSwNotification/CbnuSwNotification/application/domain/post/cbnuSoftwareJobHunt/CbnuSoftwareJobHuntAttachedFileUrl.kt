package com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.AttachedFileName
import jakarta.persistence.*

@Entity
class CbnuSoftwareJobHuntAttachedFileUrl(
    @Embedded
    val name: AttachedFileName,

    @Lob
    val url: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cbnu_software_job_hunt_post_id", nullable = false)
    val post: CbnuSoftwareJobHuntPost,
) {
    @Id
    @GeneratedValue
    @Column(name = "cbnu_software_job_hunt_attached_file_url_id")
    val id: Long? = null

}