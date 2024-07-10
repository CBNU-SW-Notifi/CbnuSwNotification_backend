package com.CbnuSwNotification.CbnuSwNotification.crawling.util

import org.apache.commons.text.StringEscapeUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Safelist

class Util {
    companion object{
        fun br2nl(html: String?): String? {
            if (html == null) return html
            val document: Document = Jsoup.parse(html)
            document.outputSettings(Document.OutputSettings().prettyPrint(false)) //makes html() preserve linebreaks and spacing
            val s: String = document.html().replace("\\n", "\n")
            val result=Jsoup.clean(s, "", Safelist.none(), Document.OutputSettings().prettyPrint(false))
            return StringEscapeUtils.unescapeHtml3(result)
        }

    }
}