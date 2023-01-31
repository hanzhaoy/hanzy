package org.sang.hanzy.niuke.huawei.rumen;

import java.util.Scanner;

/**
 * @description
 * @author: hanchaoyang
 * @createDate: 2022/8/6 9:19
 * @version: 1.0
 **/

public class 提取不重复的整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        char[] chars = String.valueOf(i).toCharArray();
        String result ="";
        for (int a = chars.length-1; a >= 0;a--){
            if (!result.contains(String.valueOf(chars[a]))){
                result = result+chars[a];
            }
        }
        System.out.println(result);
    }
}
