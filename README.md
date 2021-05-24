# [Java Regex](https://github.com/happyflyer/Java-Regex)

- [正则表达式 - 语法](http://www.runoob.com/regexp/regexp-syntax.html)
- [Java 正则表达式详解](https://segmentfault.com/a/1190000009162306)

## 1. 什么是正则表达式

正则表达式(Regular Expression, regex)

- 定义一个**搜索模式**(pattern)的**字符串**

例如：

- `runoo+b`，可以匹配 `runoob`、`runooob`、`runoooooob`
- `runoo*b`，可以匹配 `runob`、`runoob`、`runoooooob`
- `colou?r` 可以匹配 `color` 或者 `colour`

正则表达式可以用于**搜索**、**编辑**和**操作**文本。

正则表达式对文本的分析或修改过程

- 首先正则表达式应用的是文本字符串(text/string)
- 它会以定义的模式**从左到右**匹配文本
- 每个源字符只匹配一次

## 2. 语法规则

### 2.1. 常见匹配符号

- `.`：匹配所有字符，除了换行符(Linux 中的换行符为`\n`，Windows 中的换行符为`\r\n`)
- `^regex`：匹配字符串开头
- `regex$`：匹配字符串结尾
- `[abd]`：复选集，匹配字母 `a` 或 `b` 或 `c`
- `[abc][vz]`：多个复选集，匹配字母 `a` 或 `b` 或 `c`，后面跟着 `v` 或 `z`
- `[^abc]`：否定模式，匹配所有字符，除了 `a` 或 `b` 或 `c`
- `[a-d1-7]`：匹配 `a` 到 `d` 之间的字母和 `1` 到 `7` 之间的数字
- `XZ`：匹配 `X` 后直接跟着 `Z`
- `X|Z`：匹配 `X` 或 `Z`
- `\bRe`：匹配单词边界
- `gex\b`：匹配单词边界
- `\Bege`：匹配非单词边界

正则表达式对于 `[]` 中的 `.`，会自动处理为 `[\.]`，即普通字符 `.` 进行匹配。

### 2.2. 元字符

元字符是一个预定义的字符。

- `\d`：匹配一个数字，等价于 `[0-9]`
- `\D`：匹配一个非数字，等价于 `[^0-9]`
- `\s`：匹配一个空格，等价于 `[ \t\n\x0b\r\f]`
- `\S`：匹配一个非空格
- `\w`：匹配一个单词字符(大小写字母、数字、下划线)，等价于 `[a-zA-Z_0-9]`
- `\W`：匹配一个非单词字符(除了大小写字母、数字、下划线之外的字符),等价于 `[^\w]`

### 2.3. 限定符

限定符定义了一个元素可以发生的频率。

- `{X}`：只匹配 `X` 个字符，例：`\d{3}`表示匹配 3 个数字，`.{10}`表示匹配任何长度是 10 的字符串
- `{X,}`：至少匹配 `X` 个字符，例：`\d{3,}`
- `{X,Y}`：匹配 >= `X` 且 <= `Y` 个，例：`\d{1,4}`
- `*`：匹配 >= 0 个字符，等价于 `{0,}`，例：`X*`表示匹配零个或多个字母`X`
- `+`：匹配 >= 1 个字符，等价于 `{1,}`，例：`X+`
- `?`：匹配 0 个或 1 个，等价于 `{0,1}`，例：`X?`
- `*?`：**非贪婪模式**(尽可能少的匹配字符)，限定符 `*` 或 `+` 或 `?` 或 `{}` 后面的第一个字符

使用正则表达式匹配时默认为**贪婪模式**，就是说，当匹配到目标字符或字符串后，还会继续向右搜索。

`*`、`+` 限定符都是贪婪的，因为它们会尽可能多的匹配文字，只有在它们的后面加上一个 `?` 就可以实现非贪婪或最小匹配。

## 3. Java 的正则表达式

### 3.1. Java 中的反斜杠

反斜杠 `\` 在 Java 中表示转义字符，这意味着 `\` 在 Java 拥有预定义的含义。

这里例举两个特别重要的用法

- 在匹配 `.` 或 `{`、`[`、`(`、`?`、`$`、`^`、`*` 这些特殊字符时
  - 需要在前面加上 `\\`
  - 比如匹配 `.` 时，Java 中要写为 `\\.`
  - 但对于正则表达式来说是 `\.`
- 在匹配 `\` 时
  - Java 中要写为 `\\\\`
  - 但对于正则表达式来说就是 `\\`

Java 中的正则表达式字符串有两层含义

- 首先 Java 字符串转义出符合正则表达式语法的字符串
- 然后再由转义后的正则表达式进行模式匹配

### 3.2. String 的正则处理方法

`String` 对象的四个常用的使用正则表达式的 `public` 方法。

- `matches(String regex) : boolean`
- `split(String regex) : String[]`
- `split(String regex, int limit) : Stirng[]`
- `replaceFirst(String regex, String replacem7ent) : String`
- `replaceAll(String regex, String replacement) : String`

```java
System.out.println("wxj".matches("wxj"));
```

```java
String[] array = "w x j".split("\\s");
for (String item : array) {
    System.out.println(item);
}
```

```java
System.out.println("w x j".replaceFirst("\\s", "-"));
```

```java
System.out.println("w x j".replaceAll("\\s", "-"));
```

### 3.3. 模式与匹配

Java 中使用正则表达式需要用到两个类：

- `java.util.regex.Pattern`
- `java.util.regex.Matcher`

Java 中使用正则表达式的三步骤：

1. 通过正则表达式创建模式对象 `Pattern`
2. 通过模式对象 `Pattern`，根据指定字符串创建匹配对象 `Matcher`
3. 通过匹配对象 `Matcher`，根据正则表达式操作字符串

```java
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
```

```java
// 创建第两个模式，将空格替换为 tab
final Pattern replace = Pattern.compile("\\s+");
Matcher matcher2 = replace.matcher(text);
System.out.println(matcher2.replaceAll("\t"));
```

```java
final Pattern pattern = Pattern.compile("\\w+", Pattern.CASE_INSENSITIVE);
final Pattern pattern = Pattern.compile("(?i)\\w+"); // 推荐写法
```

## 4. 分组与反向引用

### 4.1. 分组和反向引用

分组使用 `()`。

$$(第一组)(第二组)(第三组)...(第n组)$$

- 模式分组后会在正则表达式中创建**反向引用**
- 反向引用会保存匹配模式分组的字符串片断
- 这使得我们可以获取并使用这个字符串片断

在以正则表达式替换字符串的语法中

- 是通过 `$` 来引用分组的反向引用
- `$0` 是匹配完整模式的字符串(在 JavaScript 中是用 `$&` 表示)
- `$1` 是第一个分组的反向引用
- `$2` 是第二个分组的反向引用
- 以此类推

```java
String str = "img.jpg.jpg.png.jpg";
final Pattern pattern = Pattern.compile("(jpg|png)");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.start());
    System.out.println(matcher.end());
    System.out.println(matcher.group());
    System.out.println(matcher.group(1));
    System.out.println();
}
```

### 4.2. 分组但不创建反向引用

当我们在小括号 `()` 内的模式开头加入 `?:`，那么表示这个模式仅分组，但不创建反向引用。

```java
String str = "img.jpg.jpg.png.jpg";
final Pattern pattern = Pattern.compile("(?:jpg|png)");
Matcher matcher2 = pattern.matcher(str);
while (matcher2.find()) {
    System.out.println(matcher2.start());
    System.out.println(matcher2.end());
    System.out.println(matcher2.group());
    System.out.println();
}
```

区别 `[]` 和 `()`：

- `[jpg|png]` 代表匹配 `j` 或 `p` 或 `g` 或 `p` 或 `n` 或 `g` 中的任意一个字符。
- `(jpg|png)` 代表匹配 `jpg` 或 `png`。

三个非捕获元：

- `?:`，分组但不创建反向引用
- `?=`，正向预查，在任何开始匹配圆括号内的正则表达式模式的位置来匹配搜索字符串
- `?!`，负向预查，在任何开始不匹配该正则表达式模式的位置来匹配搜索字符串

### 4.3. 分组的反向引用副本

Java 中可以在小括号中使用 `?<name>` 将小括号中匹配的内容保存为一个名字为 `name` 的副本。

```java
String str = "@wxj 你好啊";
final Pattern pattern = Pattern.compile("@(?<first>\\w+\\s)");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group());
    System.out.println(matcher.group(1));
    System.out.println(matcher.group("first"));
}
```

### 4.4. 否定先行断言

我们可以创建否定先行断言模式的匹配，即某个字符串后面**不包含**另一个字符串的匹配模式。

否定先行断言模式通过 `(?!pattern)` 定义。比如，我们匹配后面不是跟着 "b" 的 "a"：`a(?!b)`。

### 4.5. 指定正则表达式的模式

可以在正则的开头指定模式修饰符。

- `(?i)` 表示**忽略大小写**
- `(?s)` 表示**单行模式**，使正则表达式的 `.` 匹配所有字符，包括换行符
- `(?m)` 表示**多行模式**，使正则表达式的 `^` 和 `$` 匹配字符串中每行的开始和结束

```java
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
```

```java
str: Hello , World .
pattern: (\w)(\s+)([.,])
s0: Hello , World .
s1: Hello World
s2: Hell  Worl
s3: Hell, Worl.
result: Hello, World.
```

## 5. 若干例子

### 5.1. 中文

`[\u4e00-\u9fa5]+` 代表匹配中文字。

```java
String str = "閑人到人间";
final Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5]+");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group());
}
```

### 5.2. 数字范围

匹配 `1990` 到 `2017`。

```java
String str = "1990\n2010\n2017";
final Pattern pattern = Pattern.compile("(?m)^1990$|^199[1-9]$|^20[0-1][0-6]$|^2017$");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group());
}
```

### 5.3. img 标签

```java
String str = "<img  src='aaa.jpg' /><img src=bbb.png/><img src=\"ccc.png\"/>" +
        "<img src='ddd.exe'/><img src='eee.jpn'/>";
// 这里我们考虑了一些不规范的 img 标签写法，比如：空格、引号
final Pattern pattern = Pattern.compile("<img\\s+src=(?:['\"])?(?<src>\\w+.(jpg|png))(?:['\"])?\\s*/>");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group("src"));
}
```

```java
aaa.jpg
bbb.png
ccc.png
```

### 5.4. 贪婪模式与非贪婪模式

```java
String str = "<div>文章标题</div><div>发布时间</div>";
final Pattern pattern = Pattern.compile("<div>(?<title>.+)</div>");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group("title"));
}
```

```java
文章标题</div><div>发布时间
```

```java
String str = "<div>文章标题</div><div>发布时间</div>";
final Pattern pattern2 = Pattern.compile("<div>(?<title>.+?)</div>");
Matcher matcher2 = pattern2.matcher(str);
while (matcher2.find()) {
    System.out.println(matcher2.group("title"));
}
```

```java
文章标题
发布时间
```
