package com.CbnuSwNotification.CbnuSwNotification.crawling

import com.CbnuSwNotification.CbnuSwNotification.application.repository.attachedFileUrlRepository.AttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.imageUrlRepository.ImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.postRepository.PostRepository
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.CrawlingLastIndex
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.repository.CrawlingLastIndexRepository
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class CrawlingAllJobHunt(
    private val postRepository: PostRepository,
    private val imageUrlRepository: ImageUrlRepository,
    private val attachedFileUrlRepository: AttachedFileUrlRepository,
    private val crawlingLastIndexRepository: CrawlingLastIndexRepository,
) {
    private val targetUrl = "https://software.cbnu.ac.kr/sub0402"
    private val conn= Jsoup.connect(targetUrl)

    fun getAllPost(){
        val document = conn.get()
        val jobHuntList = document.getElementsByClass("bd_lst")[0].getElementsByTag("tbody")[0].getElementsByTag("tr")
        val lastIndex = getLastIndex()

        for(line in jobHuntList) {
            val url = line.getElementsByClass("title")[0].childNodes()[1].attr("href")
            val num = line.getElementsByClass("no")[0].text().trim()

            if (alreadyCrawled(lastIndex.lastIndex,num)){
                break;
            }

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

        if (jobHuntList!=null) {
            lastIndex.lastIndex=jobHuntList[0].getElementsByClass("no")[0].text().trim()
        }
    }

    private fun getLastIndex():CrawlingLastIndex{
        var lastIndex = crawlingLastIndexRepository.findByUrl(targetUrl)
        if(lastIndex==null){
            lastIndex = CrawlingLastIndex(targetUrl, "0")
            crawlingLastIndexRepository.save(lastIndex)
        }
        return lastIndex
    }

    /**
     * @param strLastNum 이미 크롤링 된 마지막 위치
     * @param strListNum 지금 크롤링을 하려고 하는 위치
     */
    private fun alreadyCrawled(strLastNum: String, strListNum: String): Boolean {
        val listNum = strListNum.toLong()
        val lastNum = strLastNum.toLong()

        println("listNum = ${listNum}")
        println("lastNum = ${lastNum}")

        return (listNum <= lastNum)
    }
}