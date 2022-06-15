/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class DivisibleSumPairs {
    /*
    
    */
    public static void main(String[] args) {
//        int arr[] = {1, 3, 2, 6, 1, 2};
//        int n = arr.length;
//        int k = 3;
//        int rs = 0;
//        for(int i=0; i<n-1; i++){
//            for(int j=i+1; j<n; j++){
//                if((arr[i]+arr[j])%k == 0){
//                   rs++; 
//                }
//            }
//        }
//        System.out.println("result "+rs);
        
        //migratori bird
//        Integer ch[] = {2,2,3,2,2,3,3,3};
//        List<Integer> bird = Arrays.asList(ch);
//        if(migratoriBird(bird)){
//            System.out.println("Migratori bird done.");
//        }
        
        //shock pair
//        int n = 9;
//        int ar[]={10, 20, 20, 10, 10, 30, 50, 10, 20};
//        
//        if(shockPair(n, ar)){
//            System.out.println("Shock pair done.");
//        }
        
//        //counting valleys
//        String valleys = "DDUU";
//        int n = valleys.length();
//
//        if(countingValleys(n, valleys)){
//            System.out.println("Counting valleys done.");
//        }
        
        //jumping on the cloud
//        int c[] = {0, 0, 1, 0, 0, 1, 0};
//        int n = c.length;
//        if(jumpingOnTheCloud(n, c)){
//            System.out.println("Jumping on the cloud done");
//        }
        
        //repeated string
        String s = "aa";
        int n = 100;
        if(repeatString(n, s)){
            System.out.println("Repeat String done.");
        }
    }

    private static boolean migratoriBird(List<Integer> bird) {
        List<Integer> listA = new ArrayList<>();
        listA.addAll(bird);
//        List<Integer> listB = new ArrayList<>();
//        List<Integer> listC = new ArrayList<>();
        int modus = 0;
        int maxcount = 0;
//        for(int i=0; i<listA.size(); i++){
//            int count = 0;
//            for(int a : listA){
//                if(listA.get(i).equals(a) ){
//                    count++;
//                }
//            }
//            if(!listB.contains(listA.get(i))){
//                listB.add(listA.get(i));
//                listC.add(count);
//            }
//        }
//        System.out.println("list A "+listA);
//        System.out.println("list B "+listB);
//        System.out.println("list C "+listC);
        
//        System.out.println(listA.stream().count());
            
        for(int i=0; i<listA.size(); i++){
            int count = 0;
            for(int a : listA){
                if(listA.get(i).equals(a) ){
                    count++;
                }
            }
            if(count>maxcount){
                maxcount=count;
                modus=listA.get(i);
            }else if(count == maxcount && modus > listA.get(i)){
                modus=listA.get(i);
            }
        }
        System.out.println("modus "+modus);
        
        return true;
    }

    private static boolean shockPair(int n, int[] ar) {
        /*
        John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

        For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

        Function Description

        Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

        sockMerchant has the following parameter(s):

        n: the number of socks in the pile
        ar: the colors of each sock
        Input Format

        The first line contains an integer , the number of socks represented in . 
        The second line contains  space-separated integers describing the colors  of the socks in the pile.

        Constraints

         where 
        Output Format

        Return the total number of matching pairs of socks that John can sell.

        Sample Input

        9
        10 20 20 10 10 30 50 10 20
        Sample Output

        3
        */
        List<Integer> listI = new ArrayList<>();
        int result = 0;
        for(int i=0; i<n; i++){
            int count=0;
            for(int j : ar){
                if(ar[i]==j){
                    count++;
                }
            }
            if(!listI.contains(ar[i]) && count%2==0){
                listI.add(ar[i]);
                result += count/2;
            }else if(!listI.contains(ar[i]) && count%2==1){
                listI.add(ar[i]);
                result += (count-1)/2;
            }
        }
        System.out.println("shock pair "+result);
        return true;
    }

    private static boolean countingValleys(int n, String valleys) {
        int lvl = 0;
        int v = 0;
        for(char c : valleys.toCharArray()){
            if(c == 'U') lvl++;
            if(c == 'D') lvl--;
            
            if(lvl==0 && c == 'U')
                v++;
            
            }
        System.out.println("Max Valley "+v);
        return true;
    }

    private static boolean jumpingOnTheCloud(int n, int[] c) {

        int jump = 0;
        int position = 0;
        int a=0;
        for (int i = 0; i < c.length; i=i+a) {
            if(i<c.length-2){
                if(c[position]==c[i+2]){
                    position=i+2;
                    jump++;
                    a=2;  
                }else{
                    position=i+1;
                    jump++;
                    a=1;  
                }
            }else{
                if(position==c.length-2 && c[c.length-1]==0){
                    position++;
                    jump++;
                }
            }
        }
        System.out.println("jump "+jump);
        return true;
    }

    private static boolean repeatString(long n, String s) {
        int count = 0;
        if(s.equalsIgnoreCase("a")){
            count = new Integer((int) n);
        }else{
            String rs = "";
            for(int i=0; i<n; i=i+s.length()){
                for(int j=0; j<s.length(); j++){
                    if(rs.length()<n){
                        rs += s.charAt(j);
                    }else{
                        break;
                    }

                }
            }
            char ch[] = rs.toCharArray();

            for(char c : ch){
                if(c=='a'){
                    count++;
                }
            }
        }

        System.out.println("count "+count);
        return true;
        
    }
    
}
