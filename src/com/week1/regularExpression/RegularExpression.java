package com.week1.regularExpression;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式测试
 */

public class RegularExpression {
    public static void main(String[] args) {
        //第一种：创建Pattern对象
        //在这个字符串: asfsdf23323，是否符合指定的正则表达式: \W
        //表达式对象
        Pattern p = Pattern.compile("\\w+");
        //创建Matcher对象
        Matcher m = p.matcher("64564564&&6adsadsad&&cascasda");
        //match匹配整个字符串
        boolean flag = m. matches( );
        System.out.println(flag);

        //find寻找符合的字符串
        // System.out.println(m.find());
        //获取匹配结果
        while(m.find()) {
            System.out.println(m.group());
        }

        //分组获取字符串
        Pattern P = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher M = P.matcher(" aa232**ssd445*sds223");
        while(M.find()) {
            System.out.println(M.group());
            //按正则表达式分组获取字符串
            System.out.println(M.group(1));
            System.out.println(M.group(2));
        }

        //替换字符串
        Pattern p1 = Pattern.compile("[0-9]");
        Matcher m1 = p1.matcher("aa232**ssd445*sds223");
        String newStr = m1.replaceAll("#");
        System.out.println(newStr);

        //分割
        String string = "a1231f654564asas564564dqwdq";
        String [] strings = string.split("\\d+");
        System.out.println(Arrays.toString(strings));

        //第二种：使用字符串的matches方法
        //匹配电话号码、邮箱
        String tel = "13845646872";
        System.out.println(tel.matches("(0\\d{2,3}-\\d{7,9})|(1[35789]\\d{9})"));
        String email = "chenxiligem@163.com";
        System.out.println(email.matches("[\\w\\-]+@[a-z0-9A-Z]+(\\.[A-Za-z]{2,4}){1,2}"));
    }
}
