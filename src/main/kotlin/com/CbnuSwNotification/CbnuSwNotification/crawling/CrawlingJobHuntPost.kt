package com.CbnuSwNotification.CbnuSwNotification.crawling

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.AttachedFileName
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostContent
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ValueObject.PostTitle
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntAttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.cbnuSoftwareJobHunt.CbnuSoftwareJobHuntPost
import com.CbnuSwNotification.CbnuSwNotification.crawling.util.Util
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Safelist
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class CrawlingJobHuntPost(
    private val url: String
) {
    private val document: Document
    private val conn=Jsoup.connect(url)
    private val log = LoggerFactory.getLogger(CrawlingJobHuntPost::class.java)

    init {
        log.info("크롤링을 위한 연결: ${url}")
        this.document = conn.get()
    }

    fun getPost(): CbnuSoftwareJobHuntPost {
        return CbnuSoftwareJobHuntPost(
            title = PostTitle(document.getElementsByClass("np_18px").text()),
            content = PostContent(Util.br2nl(document.getElementsByClass("xe_content")[0].html())?: ""),
            createTime = LocalDateTime.parse(
                document.getElementsByClass("date")[0].text(),
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
            ),
        )
    }

    fun getImage(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): List<CbnuSoftwareJobHuntImageUrl> {
        val images = document.getElementsByClass("xe_content")[0].getElementsByTag("img")
        val imageList = mutableListOf<CbnuSoftwareJobHuntImageUrl>()
        for (image in images) {
            if(image.attr("src").length<=1000) {
                imageList.add(
                    CbnuSoftwareJobHuntImageUrl(
                        url = image.attr("src"),
                        post = cbnuSoftwareJobHuntPost,
                    )
                )
            }
        }
        return imageList
    }

    fun getAttachedFile(cbnuSoftwareJobHuntPost: CbnuSoftwareJobHuntPost): List<CbnuSoftwareJobHuntAttachedFileUrl> {
        val fnt=document.getElementsByClass("rd_fnt")
        val fileList= mutableListOf<CbnuSoftwareJobHuntAttachedFileUrl>()
        if(fnt.size>=1) {
            val files = fnt[0].getElementsByClass("bubble")
            for (file in files) {
                if(file.attr("href").length<=1000) {
                    fileList.add(
                        CbnuSoftwareJobHuntAttachedFileUrl(
                            name = AttachedFileName(file.childNodes()[0].toString()),
                            url = file.attr("href"),
                            post = cbnuSoftwareJobHuntPost,
                        )
                    )
                }
            }
        }
        return fileList
    }




}