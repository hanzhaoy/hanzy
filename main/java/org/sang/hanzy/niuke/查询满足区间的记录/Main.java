package org.sang.hanzy.niuke.查询满足区间的记录;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s0 = bf.readLine();
        int n = Integer.parseInt(s0);//记录数
        String s1 = bf.readLine();
        int A = Integer.parseInt(s1);//时间值A
        int[] codes= new int[n];
        List<String> result = new ArrayList<>();
        HashMap<Integer, HashMap<String,Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map1 = new HashMap<>();
            String[] s2 = bf.readLine().split(" ");
            int code = Integer.parseInt(s2[0]);
            int start = Integer.parseInt(s2[1]);
            int end = Integer.parseInt(s2[2]);
            codes[i]=code;
            map1.put("start",start);
            map1.put("end",end);
            map.put(code,map1);
        }
        for (int i = 0; i <codes.length; i++) {
            HashMap<String, Integer> map1 = map.get(codes[i]);
            if (A>=map1.get("start")&&A<=map1.get("end")){
                    result.add(String.valueOf(codes[i]));
                }
        }

        if (!result.isEmpty()){
            Object[] a = result.toArray();
            Arrays.sort(a);
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }else {
            System.out.println("null");
        }
    }
}

