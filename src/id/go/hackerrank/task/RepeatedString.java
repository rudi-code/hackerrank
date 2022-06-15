package id.go.hackerrank.task;

/**
 * 
 * @author Rudi Purnomo
 * Date 13-jun-2020
 * 
 */
/**
 * Task
 * 
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 * Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
 * For example, if the string s='abcac and n=10, the substring we consider is abcacabcac, the first 10 characters of her infinite string. 
 * There are 4 occurrences of a in the substring.
 * 
 * Function Description
 * 
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of 
 * occurrences of a in the prefix of length n in the infinitely repeating string. repeatedString has the following parameter(s):
 * s: a string to repeat
 * n: the number of characters to consider
 * 
 * Input Format
 * The first line contains a single string, s.
 * The second line contains an integer, n.
 * 
 * Constraints
 * 1<=|s|<=100
 * 1<=n<=10^12
 * For 25% of the test cases, n<=10^6.
 * 
 * Output Format
 * Print a single integer denoting the number of letter a's in the first n letters of the infinite string 
 * created by repeating s infinitely many times.
 */

public class RepeatedString {
	
	public static long OccurrencesA(String s, long n) {
		
		long q = n/s.length();
		long r = n%s.length();
		
		if(!s.contains("a")) return 0;
		else {
			return s.length() > n ? proses(s,n): q*proses(s, s.length())+proses(s, r);
		}
	}

	private static long proses(String s, long n) {
        int count=0;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == 'a') count++;
        }
        return count;
    }
	
	
}
