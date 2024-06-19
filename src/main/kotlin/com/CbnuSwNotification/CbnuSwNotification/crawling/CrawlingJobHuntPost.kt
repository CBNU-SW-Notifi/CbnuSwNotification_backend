package com.CbnuSwNotification.CbnuSwNotification.crawling

import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.AttachedFileUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.ImageUrl
import com.CbnuSwNotification.CbnuSwNotification.application.domain.post.Post
import com.CbnuSwNotification.CbnuSwNotification.common.dataType.PostType
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

    private fun br2nl(html: String?): String? {
        if (html == null) return html
        val document: Document = Jsoup.parse(html)
        document.outputSettings(Document.OutputSettings().prettyPrint(false)) //makes html() preserve linebreaks and spacing
        document.select("br").append("\n")
        document.select("p").prepend("\n\n")
        val s: String = document.html().replace("\\n", "\n").replace("&nbsp;"," ")
        return Jsoup.clean(s, "", Safelist.none(), Document.OutputSettings().prettyPrint(false))
    }

    fun getPost(): Post {
        return Post(
            title = document.getElementsByClass("np_18px").text(),
            content = br2nl(document.getElementsByClass("xe_content")[0].html())?: "",
            createTime = LocalDateTime.parse(
                document.getElementsByClass("date")[0].text(),
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
            ),
            postType = PostType.COMMON,
        )
    }

    fun getImage(post: Post): List<ImageUrl> {
        val images = document.getElementsByClass("xe_content")[0].getElementsByTag("img")
        val imageList = mutableListOf<ImageUrl>()
        for (image in images) {
            if(image.attr("src").length<=1000) {
                imageList.add(
                    ImageUrl(
                        url = image.attr("src"),
                        post = post,
                    )
                )
            }
        }
        return imageList
    }

    fun getAttachedFile(post: Post): List<AttachedFileUrl> {
        val fnt=document.getElementsByClass("rd_fnt")
        val fileList= mutableListOf<AttachedFileUrl>()
        if(fnt.size>=1) {
            val files = fnt[0].getElementsByClass("bubble")
            for (file in files) {
                if(file.attr("href").length<=1000) {
                    fileList.add(
                        AttachedFileUrl(
                            name = file.childNodes()[0].toString(),
                            url = file.attr("href"),
                            post = post,
                        )
                    )
                }
            }
        }
        return fileList
    }




}