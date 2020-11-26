package org.example.java_regex.re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 模式与匹配
 *
 * @author lifei
 */
public class Demo2 {
    public static void main(String[] args) {
        String text = "Hello Regex!";
        final Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        // 遍例所有匹配的序列
        while (matcher.find()) {
            System.out.println("Start index: " + matcher.start());
            System.out.println("End index: " + matcher.end());
            System.out.println(matcher.group());
            System.out.println();
        }
        // 创建第两个模式，将空格替换为 tab
        final Pattern replace = Pattern.compile("\\s+");
        Matcher matcher2 = replace.matcher(text);
        System.out.println(matcher2.replaceAll("\t"));
    }
}
