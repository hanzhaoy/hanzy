package org.sang.hanzy.niuke.幼儿园分班;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result=1;
        int n = sc.nextInt();//共n个小朋友
        int m = sc.nextInt();//采集了m位小朋友
        Set<Integer> set1 = new HashSet<>(); //1班
        Set<Integer> set2 = new HashSet<>();//2班
        for (int i = 0; i < m; i++) {
            int req = sc.nextInt(); //请求的小朋友
            int no = sc.nextInt(); //不想同班
            if (!set1.contains(req)&&!set2.contains(req)){
                set1.add(req);
                set2.add(no);
            }else if (set1.contains(req)){
                set2.add(no);
            }else if (set2.contains(req)){
                set1.add(no);
            }
            if(set1.contains(req)&& set1.contains(no) ||set2.contains(req)&& set2.contains(no)){
                result=0;
                break;
            }
        }
        System.out.println(result);
    }
}
