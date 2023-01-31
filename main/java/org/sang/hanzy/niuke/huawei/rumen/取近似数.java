package org.sang.hanzy.niuke.huawei.rumen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description
 * @author: hanchaoyang
 * @createDate: 2022/8/6 8:54
 * @version: 1.0
 **/

public class 取近似数 {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str;
            while (sc.hasNext()) {
                str = sc.nextLine();
                while (str.length() > 8) {
                    System.out.println(str.substring(0, 8));
                    str = str.substring(8);
                }
                str = str + "00000000";
                System.out.println(str.substring(0, 8));
            }
        }

}
