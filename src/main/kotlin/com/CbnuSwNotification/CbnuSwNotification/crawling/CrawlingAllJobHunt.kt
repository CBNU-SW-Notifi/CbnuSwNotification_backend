package com.CbnuSwNotification.CbnuSwNotification.crawling

import com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository.AttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrlRepository.ImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class CrawlingAllJobHunt(
    private val postRepository: PostRepository,
    private val imageUrlRepository: ImageUrlRepository,
    private val attachedFileUrlRepository: AttachedFileUrlRepository,
) {
    private val targetUrl = "https://software.cbnu.ac.kr/sub0402"
    private val conn= Jsoup.connect(targetUrl)

    fun getAllPost(){
        val document = conn.get()
        val jobHuntList = document.getElementsByClass("bd_lst")[0].getElementsByTag("tbody")[0].getElementsByTag("tr")

        for(line in jobHuntList) {
            val url = line.getElementsByClass("title")[0].childNodes()[1].attr("href")
            val num = line.getElementsByClass("no")[0].text().trim()
            val crawlingJobHuntPost = CrawlingJobHuntPost(url)

            val post = crawlingJobHuntPost.getPost()
            postRepository.save(post)

            val images = crawlingJobHuntPost.getImage(post)
            for (image in images){
                imageUrlRepository.save(image)
            }

            val files = crawlingJobHuntPost.getAttachedFile(post)
            for(file in files){
                attachedFileUrlRepository.save(file)
            }
        }
    }
}