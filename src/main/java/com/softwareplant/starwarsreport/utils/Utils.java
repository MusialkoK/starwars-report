package com.softwareplant.starwarsreport.utils;

public class Utils {

    public static Long getIdFromUrl(String url) {
        String[] splicedUrl = url.split("/");
        return Long.valueOf(splicedUrl[splicedUrl.length - 1]);

    }
}
