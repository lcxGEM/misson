package com.datatype;

public class DataTypeTest {
    public static void main(String[] args) {
        // 基本数据类型：byte、char、short、int、long、float、double、boolean
        // 自动转换，基本类型从小到大转换
        byte a = 1;
        char b = 'a';
        short c = a;
        int d = b;
        int e = c;
        long f = e;
        float g = f;
        double h = g;
        System.out.println(a+", "+b+", "+c+", "+d+", "+e+", "+f+", "+g+", "+h);
        // 强制类型转换，基本类型从大到小转换
        // 强制类型转换规则：
        // 浮点型数据转化成整型数据直接截断小数后的部分。
        // 整型数据如果超出数据范围，由低位到可以取到的最高位截取数据。重新解析(此时的符号位是原来的数据位，因此数据征服可能会变化)
        double dou = -1055555.6;
        float flo = (float) dou;
        long lon = (long)flo;
        int in = (int) lon;
        int i = 32768;
        short sho = (short) i;//取值范围-32768~32767
        short shor = 128;
        byte byt = (byte) shor;//取值范围-128~127
        System.out.println(dou+", "+flo+", "+lon+", "+in+", "+sho+", "+byt);
        char cha = 'A';
        int ch = cha;
        byte bb= (byte) cha;
        System.out.println(cha+", "+ch+", "+ bb);
    }
}
