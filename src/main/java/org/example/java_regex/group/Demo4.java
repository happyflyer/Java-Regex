package org.example.java_regex.group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组的反向引用副本
 *
 * @author lifei
 */
public class Demo4 {
    public static void main(String[] args) {
        String str = "@wxj 你好啊";
        final Pattern pattern = Pattern.compile("@(?<first>\\w+\\s)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group("first"));
        }
    }
}
