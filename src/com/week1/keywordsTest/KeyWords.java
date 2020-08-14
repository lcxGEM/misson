package com.week1.keywordsTest;

import com.week1.keywords.KeyWordsTest;

public class KeyWords extends KeyWordsTest{
    public static void main(String[] args) {
        //访问控制符跨包测试
        KeyWordsTest k = new KeyWordsTest();
        System.out.println(k.a);//public访问控制符，跨包使用
        KeyWords key = new KeyWords();
        System.out.println(key.b);//protected访问控制符，跨包的继承类可以使用
    }
}
