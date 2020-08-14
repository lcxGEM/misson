package com.week1.keywords;

public final class KeyWordsTestClient {
    public static void main(String[] args) {
        //访问控制符相同包不同类测试
        KeyWordsTest k = new KeyWordsTest();
        System.out.println(k.a);
        System.out.println(k.b);
        System.out.println(k.c);
    }
}
