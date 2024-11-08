package com.macaron.homeschool.common.util;

import jakarta.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-09
 * Time: 0:35
 */
public class HttpServletUtil {

    public static String encodeString(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

    public static void warn(HttpServletResponse response, String warn) {
        response.setHeader("warn", encodeString(warn));
    }

    public static void info(HttpServletResponse response, String warn) {
        response.setHeader("info", encodeString(warn));
    }

    public static void error(HttpServletResponse response, String warn) {
        response.setHeader("error", encodeString(warn));
    }

}
