package org.sang.hanzy.niuke.最长对称子字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.length() == 1) {
            System.out.println(s);
        } else {
            char[] chars = s.toCharArray();
            List<String> list = new ArrayList<>();
            List<String> result = new ArrayList<>();
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = i; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        String substring = s.substring(i, j + 1);
                        if (Main.ishw(substring)) {
                            list.add(substring);
                        }
                    }
                }
            }
            int temp = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() > temp) {
                    temp = list.get(i).length();
                    result.clear();
                    result.add(list.get(i));
                } else if (list.get(i).length() == temp) {
                    result.add(list.get(i));
                }
            }
            ;
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }

    public static Boolean ishw(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
//a1223a
