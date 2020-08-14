package com.week1.processControl;

public class Demo1 {
    public static void main(String[] args) {
        //if else
        int a = 12;
        if(a%3==0){
            System.out.println("a能被3整除");
        }else{
            System.out.println("a不能被3整除");
        }
        //多分支if else
        int x =15;
        if(x%2==0){
            System.out.println("x能被2整除");
        }else if(x%3==0){
            System.out.println("x能被3整除");
        }else if(x%5==0){
            System.out.println("x能被5整除");
        }
        System.out.println("----------------");
        if(x%2==0){
            System.out.println("x能被2整除");
        }
        if(x%3==0){
            System.out.println("x能被3整除");
        }
        if(x%5==0){
            System.out.println("x能被5整除");
        }
        //switch
        switch (15%2){
            case 0:{
                System.out.println("能除尽");
                break;
            }
            case 1:{
                System.out.println("不能除尽");
                break;
            }
        }
    }
}
