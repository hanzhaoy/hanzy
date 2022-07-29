package org.sang.hanzy.niuke.珠玑妙算;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Result {
    public static int[] calcResult(String A, String guess) {

        int[] result=new int[2];
        if(A==null || guess==null || A.length()!=guess.length()) return result;
        int same=0,count=0;
        int[] aCount=new int[26];
        int[] gCount=new int[26];
        //"RGBY","GGRR"  "BGGB","GGRR"
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)==guess.charAt(i)){
                same++;
            }else{
                aCount[A.charAt(i)-'A']++;
                gCount[guess.charAt(i)-'A']++;
            }
        }
        for(int i=0;i<26;i++){
            if(aCount[i]<gCount[i]){
                count+=aCount[i];
            }else{
                count+=gCount[i];
            }
        }
        result[0]=same;
        result[1]=count;
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] ints = calcResult(s[0], s[1]);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}