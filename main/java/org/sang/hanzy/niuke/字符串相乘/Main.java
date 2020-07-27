package org.sang.hanzy.niuke.字符串相乘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s1 = br.readLine();
        BigInteger c = new BigInteger(s);
        BigInteger d = new BigInteger(s1);
        System.out.println(c.multiply(d));
    }
}
