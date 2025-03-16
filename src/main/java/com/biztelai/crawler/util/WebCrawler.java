package com.biztelai.crawler.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class WebCrawler {
    public static Set<String> fetchLinks(String url) {
        Set<String> links = new HashSet<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("a[href]");
            for (Element element : elements) {
                links.add(element.attr("abs:href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }
}
