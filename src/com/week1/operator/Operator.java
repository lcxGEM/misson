package com.week1.operator;

/**
 * 运算符测试
 */
public class Operator {
    public static void main(String[] args) {
        //算术运算符：+、-、*、/、%、++、--
        System.out.println("---------算术运算---------");
        long a=10000000000L;
        int b = (int) (a+1);  // 加运算
        System.out.println("加运算："+b);
        b = b-1;      // 减运算
        System.out.println("减运算："+b);
        b = (int) (a*10);     // 乘运算
        System.out.println("乘运算："+b);
        b = b/2;      // 除运算
        System.out.println("除运算："+b);
        b = b%2;      // 取余运算
        System.out.println("取余运算："+b);
        b++;          // 自加运算
        b--;          // 自减运算
        //赋值运算符：=、+=、-=、*=、/=
        System.out.println("---------赋值运算--------");
        int c = 56;   // 赋值运算
        c+=10;        //
        System.out.println(c);
        c-= b;
        System.out.println(c);
        //逻辑运算符：&&、||、！
        System.out.println("---------逻辑运算---------");
        boolean flag1 = false;
        boolean flag2 = true;
        System.out.println(!flag1);                    //非运算
        System.out.println(flag1&&(flag2=false));      //与运算（短路现象）
        System.out.println("逻辑与短路现象：");
        System.out.println(flag2);                     //逻辑与短路现象


        System.out.println(flag2||(flag1=true));       //或运算
        System.out.println("逻辑或短路现象：");        //逻辑或短路现象
        System.out.println(flag1);
        //位运算符：&、|、~、^
        System.out.println("--------位运算--------");
        byte r = 8;
        System.out.println(r&15);                      //按位与 全1为1,否则为0
        System.out.println(r|1);                       //按位或 全0位0，否则为1
        System.out.println(~r);                        //按位非 遇1为0，遇0为1、
        System.out.println(r^10);                       //按位异或 相同为0，不同为1；
        //关系运算符：>、<、>=、<=、==、!=
        System.out.println("-------关系运算--------");
        int a1 = 10;
        int b1 = 11;
        System.out.println(a1>b1);
        System.out.println(a1<b1);
        System.out.println(a1>=b1);
        System.out.println(a1<=b1);
        System.out.println(a1==b1);
        System.out.println(a1!=b1);
        //移位运算符：>>、<<、>>>、
        byte v = -15;
        System.out.println(v>>2);                      //右移运算
        System.out.println(v<<2);                      //左移运算
        System.out.println(v>>>2);                     //无符号右移运算
    }
}
