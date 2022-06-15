/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author user
 */
public class BirthdayChocolate {
    
    /*
    Lily has a chocolate bar that she wants to share it with Ron for his birthday. Each of the squares has an integer on it. She decides to share a contiguous segment of the bar selected such that the length of the segment matches Ron's birth month and the sum of the integers on the squares is equal to his birth day. You must determine how many ways she can divide the chocolate.
    Consider the chocolate bar as an array of squares,s=[2,2,1,3,2] . She wants to find segments summing to Ron's birth day,
    d=4 with a length equalling his birth month, m=2. In this case, there are two segments meeting her criteria: [2,2] and [1,3].
    Function Description
    Complete the birthday function in the editor below. It should return an integer denoting the number of ways Lily can divide the chocolate bar.
    birthday has the following parameter(s):
    s: an array of integers, the numbers on each of the squares of chocolate
    d: an integer, Ron's birth day
    m: an integer, Ron's birth month
    Input Format
    The first line contains an integer n, the number of squares in the chocolate bar. 
    The second line contains n space-separated integers s[i], the numbers on the chocolate squares where 0<= i < n. 
    The third line contains two space-separated integers, d and m, Ron's birth day and his birth month.

    Constraints
    > 1<= n <=100
    > 1<= s[i] <=5, where(0<=i<n)
    > 1<=d<=31
    > 1<=m<=12

    Output Format

    Print an integer denoting the total number of ways that Lily can portion her chocolate bar to share with Ron.

    Sample Input 0

    5
    1 2 1 3 2
    3 2
    Sample Output 0

    2
    Explanation 0

    Lily wants to give Ron m=2 squares summing to d=3. The following two segments meet the criteria:

    1+2 and 2+1

    Sample Input 1

    6
    1 1 1 1 1 1
    3 2
    Sample Output 1

    0
    */
    
    public static void main(String[] args) {
        Integer choco[] = {1,2,1,3,2};
        List<Integer> listI = Arrays.asList(choco);
        
        System.out.println("listI "+listI);
        int d = 3;
        int m = 2;
        int n = (choco.length-m)+1;
        int result = 0;
        for(int i=0; i<n; i++){
            int sem = 0;
            List<Integer> rs = listI.subList(i, m+i);
            for(int j=0; j<rs.size(); j++){
                int temp = rs.get(j);
                sem += temp;
            }
            if(sem == d){
                result++;
            }  
            
            
//            String s[] = Arrays.toString(choco).replace(",", "")
//                    .replace("[", "").replace("]", "").replace(" ", "")
//                    .substring(i, m+i).split("");
//            int sem = 0;
//            for(int j=0; j<s.length; j++){
//                int temp = new Integer(s[j]);
//                sem += temp;
//            }
//            if(sem == d){
//                result++;
//            }  
        }
        System.out.println("result "+result);
    }
}
