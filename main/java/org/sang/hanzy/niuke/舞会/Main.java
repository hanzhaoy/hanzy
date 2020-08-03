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
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            String[] s1 = br.readLine().split(" ");
            rerult += s1.length - 1;
            if (s1.length > 1) {
                //int[] ints = new int[Integer.parseInt(s1[0])];
                for (int j = 1; j < s1.length; j++) {
                    //ints[j]=Integer.parseInt(s1[j+1]);

                    list.add(Integer.parseInt(s1[j]));
                }
                map.put(i, list);
            }
        }
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            List<Integer> list1 = new ArrayList<>();
            String[] s2 = br.readLine().split(" ");
            rerult += s2.length - 1;
            if (s2.length > 1) {
                for (int j = 1; j < s2.length; j++) {
                    list1.add(Integer.parseInt(s2[j]));
                }
                map1.put(i, list1);
            }
        }
        //思路不对
        for (int i = 1; i <= n; i++) {
            List<Integer> list2 = map.get(i);
            for (int i1 = 1; i1 <= m; i1++) {
                List<Integer> put1 = map1.get(i1);
                if (list2.contains(i1)&&put1.contains(i)){
                    rerult =rerult-1;
                }
            }
        }
        System.out.println(rerult);
    }
}
