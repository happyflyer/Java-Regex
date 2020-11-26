package org.example.java_regex.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 中文匹配
 *
 * @author lifei
 */
public class Demo1 {
    public static void main(String[] args) {
        String str = "閑人到人间";
        final Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
