package org.example.java_regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数字范围匹配
 *
 * @author lifei
 */
public class Demo2 {
    public static void main(String[] args) {
        String str = "1990\n2010\n2017";
        final Pattern pattern = Pattern.compile("(?m)^1990$|^199[1-9]$|^20[0-1][0-6]$|^2017$");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
