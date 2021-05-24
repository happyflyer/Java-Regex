package org.example.java_regex.group;

/**
 * 去除单词与 `,` 和 `.` 之间的空格
 *
 * @author lifei
 */
public class Demo5 {
    public static void main(String[] args) {
        String str = "Hello , World .";
        String pattern = "(\\w)(\\s+)([.,])";
        // $0 匹配 `(\w)(\s+)([.,])` 结果为 `o空格,` 和 `d空格.`
        // $1 匹配 `(\w)` 结果为 `o` 和 `d`
        // $2 匹配 `(\s+)` 结果为 `空格` 和 `空格`
        // $3 匹配 `([.,])` 结果为 `,` 和 `.`
        System.out.println("str: " + str);
        System.out.println("pattern: " + pattern);
        System.out.println("s0: " + str.replaceAll(pattern, "$0"));
        System.out.println("s1: " + str.replaceAll(pattern, "$1"));
        System.out.println("s2: " + str.replaceAll(pattern, "$2"));
        System.out.println("s3: " + str.replaceAll(pattern, "$3"));
        System.out.println("result: " + str.replaceAll(pattern, "$1$3"));
    }
}
