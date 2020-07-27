package org.sang.hanzy.niuke.提取优惠券;

import java.util.Scanner;
public class Main{
    public static void main(String[] arg){
        String str="1Ct3r4ip_ti4C6k9Et^";
        //Scanner sc=new Scanner(System.in);
        //str=sc.next();
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])){//不是数字
                stringBuffer.append(chars[i]);
            }
        }
        System.out.println(stringBuffer);
    }
}
