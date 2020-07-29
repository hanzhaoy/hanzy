package org.sang.hanzy.niuke.密码校验;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            list.add(s);
        }
        for (String s : list) {
            System.out.println(check(s));
        }


    }

    public static String check(String s) {
        //密码长度至少为8,b不超过100
        char[] chars = s.toCharArray();
        if (s.length() < 8 && s.length() > 100) {
            return "NO";
        }
        //密码不能以数字开头；
        if (chars[0] >= '0' && chars[0] <= '9') {
            return "NO";
        }

        int a = 0;
        int b = 0;
        int c = 0;
        for (char e : chars) {
            if ((e >= 'a' && e <= 'z')) {
                a++;
            } else if ((e >= 'A' && e <= 'Z')) {
                b++;
            } else if ((e >= '0' && e <= '9')) {
                c++;
            } else { //密码只能由大写字母，小写字母，数字构成；
                return "NO";
            }
        }
        //密码中至少出现大写字母，小写字母和数字这三种字符类型中的两种；
        if ((a * b + b * c + c * a) == 0) {
            return "NO";
        }
        return "YES";
    }
}
