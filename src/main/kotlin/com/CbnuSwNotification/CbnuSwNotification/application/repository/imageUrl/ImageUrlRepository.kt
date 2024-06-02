package com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrl

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post

interface ImageUrlRepository {

    /**
     * @param imageUrl 이미지 url 객체
     * @return 저장된 객체의 id
     */
    fun save(imageUrl: ImageUrl): Long

    /**
     * @param id imageUrl의 id
     * @return imageUrl 객체
     */
    fun findById(id: Long): ImageUrl

    /**
     * @param post 사진을 얻고자하는 post객체
     * @return 해당 post의 imageUrl리스트
     */
    fun findAllByPost(post: Post): List<ImageUrl>

}