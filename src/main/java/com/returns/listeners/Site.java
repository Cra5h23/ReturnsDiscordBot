package com.returns.listeners;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author Nikolay Radzivon
 * @Date 21.08.2024
 */
public class Site {

    public String connect(String name) {
        String url = "https://sirus.su/base/character/x2/%D1%80%D0%B5%D1%82%D1%83%D1%80%D0%BD/";

        try {
            Document document = Jsoup.connect(url).userAgent("Mozilla/5.0").referrer("https://www.google.com").get();

            var select = document.selectFirst("title");


            return select.text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
