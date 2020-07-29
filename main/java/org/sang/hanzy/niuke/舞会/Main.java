package org.sang.hanzy.niuke.舞会;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rerult = 0;
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); //男嘉宾数量
        int m = Integer.parseInt(s[1]); //女嘉宾数量
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            rerult += s1.length - 1;
            if (s1.length > 1) {
                int[] ints = new int[Integer.parseInt(s1[0])];
                for (int j = 0; j < ints.length; j++) {
                    ints[j]=Integer.parseInt(s1[j+1]);
                }
                map.put(i, ints);
            }
        }
        System.out.println(map.toString());
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String[] s2 = br.readLine().split(" ");
            rerult += s2.length - 1;
            if (s2.length > 1) {
                for (int j = 1; j < s2.length; j++) {
                    list1.add(Integer.parseInt(s2[j]));
                }
                map1.put(i, list1);
            }
        }
//        for (int i = 1; i <= n; i++) {
//            int[] put = map.get(i);
//            for (int i1 = 1; i1 <= m; i1++) {
//                List<Integer> put1 = map1.get(i1);
//                if (put.contains(i1)&&put1.contains(i)){
//                    rerult =rerult-1;
//                }
//            }
//        }
        System.out.println(rerult);
    }
}
