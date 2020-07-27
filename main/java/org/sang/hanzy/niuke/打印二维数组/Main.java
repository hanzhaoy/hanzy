package org.sang.hanzy.niuke.打印二维数组;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    int k = 1;
    public void Print_array(int n, int m) throws IOException {
        int [][] arr = new int[n][m];
        ArrayList<int[]> a = new ArrayList<>();
        for(int i = 0; i<m; i++){
            a.add(new  int[]{0,i});
        }
        for(int j = 1; j<n;j++){
            a.add(new int[]{j,m-1});
        }
        for(int i = 0; i<a.size(); i++){
            fill_arr(a.get(i),arr);
        }
        for(int i = 0; i<arr.length;i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0;j<arr[0].length;j++){
                sb.append(arr[i][j]).append(" ");
            }
            System.out.println(sb.substring(0,sb.length()-1));
        }
    }

    private void fill_arr(int[] string, int[][] arr) {
        while (string[0]<=arr.length-1  && string[1]>=0){
            arr[string[0]][string[1]] = k;
            string[0]++;
            string[1]--;
            k++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        new Main().Print_array(n,m);
    }
}