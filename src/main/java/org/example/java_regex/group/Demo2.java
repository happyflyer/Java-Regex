package org.example.java_regex.group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组但不创建反向引用
 *
 * @author lifei
 */
public class Demo2 {
    public static void main(String[] args) {
        String str = "img.jpg.jpg.png.jpg";
        final Pattern pattern2 = Pattern.compile("(?:jpg|png)");
        Matcher matcher2 = pattern2.matcher(str);
        while (matcher2.find()) {
            System.out.println(matcher2.start());
            System.out.println(matcher2.end());
            System.out.println(matcher2.group());
            System.out.println();
        }
    }
}
