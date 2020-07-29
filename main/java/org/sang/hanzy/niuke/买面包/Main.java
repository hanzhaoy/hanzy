package org.sang.hanzy.niuke.买面包;

import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int types = Integer.parseInt(bf.readLine());//面包种类

        int[] prices = new int[types+1];//price[n] 表示n的价格
        int index = 0;
        for(String s : bf.readLine().split(" ")){
            prices[index++] = Integer.parseInt(s);
        }

        int sum = 0;
        for(int i = 0 ;i< prices[types] ;i++){
            String[] tem = bf.readLine().split(" ");
            //tem[0] 表示第n个种类面包，tem[1] 表示个数
            sum += prices[Integer.parseInt(tem[0])-1] * Integer.parseInt(tem[1]);
        }
        System.out.println(sum);


    }
}
