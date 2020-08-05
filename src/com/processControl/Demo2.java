package com.processControl;

public class Demo2 {
    public static void main(String[] args) {
        //for
        for (int i=0;i<10;i++){ //循环开始前赋值;循环时判断;每次循环后要执行的操作
            System.out.print(i+"\t");
        }
        System.out.println("-----------");
        //for each
        int [] array = {1,2,3,4,5,6,7,8};
        for (int aa:array) {
            System.out.print(aa+"\t");
        }
        System.out.println("----------");
        //while
        int a = 0;
        while (a<10){
            System.out.print(a+"\t");
            a++;
        }
        System.out.println("----------");
        //do while
        int b=0;
        do {
            System.out.print(b+"\t");
            b++;
        }while (b<5);
        System.out.println("----------");
        //continue跳出本次循环
        for (int i =0;i<12;i++){
            if(i%3==0){
                continue;
            }
            System.out.println(i);
        }
        //break结束该代码块执行
        for (int i =1;i<12;i++){
            if(i%3==0){
                break;
            }
            System.out.println(i);
        }
    }
}
