package org.sang.hanzy.niuke.好奇的薯队长;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int n=Integer.parseInt(s);//获取输入的数字
        long res=0;//结果
        int bit=s.length();//获取输入的数字长度
        int temp=n;
        for(int i=0;i<bit;i++){
            int p=(int)Math.pow(10,i);//p=10的i次方
            int b=temp%10; //除以10取余数
            temp=temp/10; //除以10的商
            if(b==0){//能被10整除
                res+=temp*p;
            }else if(b==1){//除以10余1
                res+=temp*p+n%p+1;
            }else if(b>1){
                res+=temp*p+p;
            }
        }
        System.out.println(res);
    }
}
