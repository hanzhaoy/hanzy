package org.sang.hanzy.niuke.小方法;

public class CheckNum {

    public static void main(String[] args){
        String s=new String("23dsfsfd3f34f45");
        char[] a=s.toCharArray();//存放字符数组bai
        char[] a1=new char[a.length];//存放修改du后的字符的数组
        int index=0;//修改后字符数组的位置
        for(int i=0;i<a.length;i++){
            if(Character.isDigit(a[i])){//进行是否数字字zhi符的判dao断
                System.out.println(a[i]);
                a1[index++]=a[i];//将数字字符存放在a1数组中
            }
        }
        s=new String(a1);
        System.out.println(s);//输出修改后的字符串
    }
}