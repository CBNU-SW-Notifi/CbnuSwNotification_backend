package com.CbnuSwNotification.CbnuSwNotification.crawling.cbnu.software.jobHunt

import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.attachedFileUrlRepository.CbnuSoftwareJobHuntAttachedFileUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.imageUrlRepository.CbnuSoftwareJobHuntImageUrlRepository
import com.CbnuSwNotification.CbnuSwNotification.application.repository.CbnuSoftwareJobHunt.postRepository.CbnuSoftwareJobHuntPostRepository
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.domain.CrawlingLastIndex
import com.CbnuSwNotification.CbnuSwNotification.crawling.lastIndex.repository.CrawlingLastIndexRepository
import com.CbnuSwNotification.CbnuSwNotification.notification.service.NotificationService
import org.jsoup.Jsoup
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Profile
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Profile("!test")
@Service
@Transactional
class CrawlingAllJobHunt(
    private val cbnuSoftwareJobHuntPostRepository: CbnuSoftwareJobHuntPostRepository,
    private val cbnuSoftwareJobHuntImageUrlRepository: CbnuSoftwareJobHuntImageUrlRepository,
    private val cbnuSoftwareJobHuntAttachedFileUrlRepository: CbnuSoftwareJobHuntAttachedFileUrlRepository,
    private val crawlingLastIndexRepository: CrawlingLastIndexRepository,
    private val notificationService: NotificationService,
) {
    private val targetUrl = "https://software.cbnu.ac.kr/sub0402"
    private val conn= Jsoup.connect(targetUrl)
    private val log = LoggerFactory.getLogger(CrawlingAllJobHunt::class.java)

    @EventListener(ApplicationReadyEvent::class)
    @Scheduled(cron = "0 0 11,15,19 * * *", zone = "Asia/Seoul")
    fun getAllPost(){
        val document = conn.get()
        val jobHuntList = document.getElementsByClass("bd_lst")[0].getElementsByTag("tbody")[0].getElementsByTag("tr")
        val lastIndex = getLastIndex()
        log.info("크롤링 시작: ${lastIndex}")

        var cnt=0;
        for(line in jobHuntList) {
            val url = line.getElementsByClass("title")[0].childNodes()[1].attr("href")
            val num = line.getElementsByClass("no")[0].text().trim()

            if (alreadyCrawled(lastIndex.lastIndex,num)){
                break;
            }

            val crawlingJobHuntPost = CrawlingJobHuntPost(url)

            val post = crawlingJobHuntPost.getPost()
            cbnuSoftwareJobHuntPostRepository.save(post)

            val images = crawlingJobHuntPost.getImage(post)
            for (image in images){
                cbnuSoftwareJobHuntImageUrlRepository.save(image)
            }

            val files = crawlingJobHuntPost.getAttachedFile(post)
            for(file in files){
                cbnuSoftwareJobHuntAttachedFileUrlRepository.save(file)
            }
            cnt++
        }

        if (jobHuntList!=null) {
            lastIndex.lastIndex=jobHuntList[0].getElementsByClass("no")[0].text().trim()
        }
        log.info("크롤링 종료: ${lastIndex}")


        log.info("알림 보내기")
        if (cnt > 0) {
            notificationService.sendMessageToAllUser(
                title = "취업정보 업데이트",
                body = "${cnt}건의 취업정보가 추가 되었습니다"
            )
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

        return (listNum <= lastNum)
    }
}