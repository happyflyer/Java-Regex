package org.example.java_regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字范围匹配
 *
 * @author lifei
 */
public class Demo4 {
    public static void main(String[] args) {
        String str = "<div>文章标题</div><div>发布时间</div>";
        // 贪婪模式
        final Pattern pattern = Pattern.compile("<div>(?<title>.+)</div>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group("title"));
        }
        // 非贪婪模式
        final Pattern pattern2 = Pattern.compile("<div>(?<title>.+?)</div>");
        Matcher matcher2 = pattern2.matcher(str);
        while (matcher2.find()) {
            System.out.println(matcher2.group("title"));
        }
    }
}
