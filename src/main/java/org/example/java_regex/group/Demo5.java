package org.example.java_regex.group;

/**
 * 去除单词与 `,` 和 `.` 之间的空格
 *
 * @author lifei
 */
public class Demo5 {
    public static void main(String[] args) {
        String Str = "Hello , World .";
        String pattern = "(\\w)(\\s+)([.,])";
        // $0 匹配 `(\w)(\s+)([.,])` 结果为 `o空格,` 和 `d空格.`
        System.out.println("str: " + Str);
        System.out.println("pattern: " + pattern);
        System.out.println("s0: " + Str.replaceAll(pattern, "$0"));
        System.out.println("s1: " + Str.replaceAll(pattern, "$1"));
        System.out.println("s2: " + Str.replaceAll(pattern, "$2"));
        System.out.println("s3: " + Str.replaceAll(pattern, "$3"));
        System.out.println("result: " + Str.replaceAll(pattern, "$1$3"));
    }
}
