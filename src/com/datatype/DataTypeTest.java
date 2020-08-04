package com.datatype;

public class DataTypeTest {
    public static void main(String[] args) {
        //基本数据类型：byte、char、short、int、long、float、double、boolean
        //自动转换
        byte a = 1;
        char b = 'a';
        short c = a;
        int d = b;
        int e = c;
        long f = e;
        float g = f;
        double h = g;
        System.out.println(a+", "+b+", "+c+", "+d+", "+e+", "+f+", "+g+", "+h);
    }
}
