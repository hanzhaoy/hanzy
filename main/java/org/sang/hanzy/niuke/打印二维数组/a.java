package org.sang.hanzy.niuke.打印二维数组;

import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] a = new int[x][y];
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j <y ; j++) {
                if (i==0&&j==0){
                    a[i][j]=1;
                }else if (j==0){
                    a[i][j]=a[i-1][j]+i;
                }else {
                    a[i][j]=a[i][j-1]+j+i+1;
                }
            }
        }
        for (int i = 0; i <y ; i++) {
            for (int j = 0; j <x ; j++) {
                if (j==y-1){
                    System.out.println(a[j][i]);
                }else {
                    System.out.print(a[j][i]+" ");
                }

            }

        }
    }
}
