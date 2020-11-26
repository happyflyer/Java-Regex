package org.example.java_regex.group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 区别 `[]` 和 `()`
 *
 * @author lifei
 */
public class Demo3 {
    public static void main(String[] args) {
        String str = "img.jpg.jpg.png.jpg";
        final Pattern pattern = Pattern.compile("[jpg|png]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println(matcher.group());
            System.out.println();
        }
    }
}
