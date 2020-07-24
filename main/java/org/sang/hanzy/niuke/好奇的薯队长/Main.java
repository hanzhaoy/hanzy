package org.sang.hanzy.niuke.好奇的薯队长;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] strings = String.valueOf(i).split("1");
            if (strings.length==1){
                result= result+String.valueOf(i).length()-1;
            }else if (strings.length==0){
                result = result+String.valueOf(i).length();
            }else if (strings.length>1){}
        }
        System.out.println(result);
    }
}
