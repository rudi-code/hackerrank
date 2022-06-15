/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class JavaApplication3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //number 1
        number1();
        
        
    }

    private static void number1() {
        /* TASK 1
        You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:
        1. The elements of the first array are all factors of the integer being considered
        2. The integer being considered is a factor of all elements of the second array
        These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.
        For example, given the arrays a=[2,6] and b=[24,36], there are two numbers between them: 6 and 12. 6%2=0,
        , 6%6=0, 24%6=0,and 36%6=0 for the first value. Similarly, 12%2=0,12%6=0 and 24%12=0, 36%12=0.
        Function Description
        Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.
        getTotalX has the following parameter(s):
        > a: an array of integers
        > b: an array of integers
        Input Format
        The first line contains two space-separated integers, n and m, the number of elements in array a and 
        the number of elements in array b. 
        The second line contains n distinct space-separated integers describing a[i] where 0 <= i < n. 
        The third line contains m distinct space-separated integers describing b[j] where 0 <= j < m.

        Constraints
        > 1 <= i,j <= 10
        > 1 <= a[i] <= 100
        > 1 <= a[j] <= 100
        Output Format
        Print the number of integers that are considered to be between a and b.
        */
//        2 4
//        16 32 96

        int a[] = {1};
        int b[] = {100};
        List<Integer> result = new ArrayList<>();
        
        for(int b1 : b){
            for(int i=1; i<=b1; i++){
                if(b1%i == 0 && loopNumber1(i, b) && loopNumber2(i, a) && !result.contains(i)){ // ambil faktor
                    result.add(i);
                }
            }
        }
        System.out.println(result.toString());
    }
    
    private static boolean loopNumber1(int i, int[] arr){
        boolean bol = true;
        for(int a : arr){
            if(a%i != 0) bol = false;
        }
        return bol; 
    }
    
    private static boolean loopNumber2(int i, int[] arr){
        boolean bol = true;
        for(int a : arr){
            if(i%a != 0) bol = false;
        }
        return bol; 
    }
    
}
