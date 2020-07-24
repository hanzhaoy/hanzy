package org.sang.hanzy.niuke.油油的旅行;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static int[] t;
    static int[] v1;
    static int[] v2;
    static HashMap<Integer, ArrayList<Integer>> map;
    static int[][] path;
    static double[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);//景点
        int m = Integer.parseInt(s1[1]);//路径
        int k = Integer.parseInt(s1[2]);//停留时间
         t = new int[n + 1]; //每个景点停留时间
         v1 = new int[n + 1];//每个景点油油愉悦度
         v2 = new int[n + 1];//每个景点小伙伴愉悦度
         path = new int[n + 1][n + 1];//路径包含连接的两个景点
         map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] s2 = br.readLine().split(" ");
            t[i] = Integer.parseInt(s2[0]);
            v1[i] = Integer.parseInt(s2[1]);
            v2[i] = Integer.parseInt(s2[2]);
        }
        map = new HashMap<>();
        path = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            map.put(i, list);
        }
        for (int i = 0; i < m; i++) {
            String[] s3 = br.readLine().split(" ");
            int a = Integer.parseInt(s3[0]);//连接Xi的景点
            int b = Integer.parseInt(s3[1]);//连接Yi的景点
            int c = Integer.parseInt(s3[2]);//该路径消耗的时间
            path[a][b] = c;//将消耗时间赋值给路径
            path[b][a] = c;
            ArrayList<Integer> list = map.get(a);
            list.add(b);
            map.put(a,list);
            list = map.get(b);
            list.add(a);
            map.put(b,list);
        }
        double result1 = 0; //油油满意度
        double result2 = 0; //小伙伴满意度
        double[] happy = new double[2]; //愉悦度
        dp = new double[n + 1][k + 1][2]; //动态规划数组
        for (int i = 1; i <= n; i++) {
            dfs(i, k - t[i], happy);
            result1 += happy[0] / n;
            result2 += happy[1] / n;
        }
        System.out.println(String.format("%.5f", result1) + " " + String.format("%.5f", result2));

    }
    private static void dfs(int index, int k, double[] result) {
        if (k < 0) return;
        if (k == 0) {
            result[0] = v1[index];
            result[1] = v2[index];
            return;
        }
        if (dp[index][k][0] != 0 && dp[index][k][1] != 0) {
            result[0] = dp[index][k][0];
            result[1] = dp[index][k][1];
            return;
        }
        result[0] = 0;
        result[1] = 0;
        ArrayList<Integer> list = map.get(index);
        int tot = 0; //当前可游玩的景点数
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            if (path[index][tmp] + t[tmp] <= k) tot++;
        }
        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            int needTime = path[index][tmp] + t[tmp];
            if (needTime <= k) {
                double[] happy = new double[2];
                dfs(tmp, k - needTime, happy);
                result[0] += happy[0] / tot;
                result[1] += happy[1] / tot;
            }
        }
        result[0] += (double) v1[index];
        result[1] += (double) v2[index];
        dp[index][k][0] = result[0];
        dp[index][k][1] = result[1];
    }
}


