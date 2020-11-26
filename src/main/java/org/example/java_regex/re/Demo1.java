package org.example.java_regex.re;

/**
 * 什么是正则表达式
 *
 * @author lifei
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("wxj".matches("wxj"));
        String[] array = "w x j".split("\\s");
        for (String item : array) {
            System.out.println(item);
        }
        System.out.println("w x j".replaceFirst("\\s", "-"));
        System.out.println("w x j".replaceAll("\\s", "-"));
    }
}
