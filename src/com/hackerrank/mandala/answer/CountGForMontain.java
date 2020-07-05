package com.hackerrank.mandala.answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountGForMontain {
	
	static List<String> listS = new ArrayList<String>();
	
//	public static void main(String[] args) {
//		
//		String[][] arr = {
//		{"G", "G", "L"},
//		{"G", "L", "L"},
//		{"L", "L", "G"}
//		};
//		
////		String[][] arr = {
////				{"L", "L", "L", "G"},  
////				{"L", "G", "G", "L"},
////				{"L", "G", "L", "L"},
////				{"G", "L", "L", "G"},
////				};
//		
////		String[][] arr = {
////				{"L", "G", "L", "G"},
////				{"G", "G", "G", "L"},
////				{"L", "G", "G", "L"},
////				{"G", "G", "G", "G"},
////				};
//		
//		int gunung = countGunung(createArray(arr), arr.length);
//		System.out.println("hasilnya ada "+gunung+" pegunungan" );
//	}
//	
	private static String[][] createArray(String[][] arr){
		
		// get length array 2 dimensi
		int n = arr.length;
		
		// inisiate new arrays 2 dimensi
		String[][] arrA = new String[n + 2][n + 2]; 
		
		// looping 2 dimensi array
		for (int i = 0; i < n + 2; i++) { 
			for (int j = 0; j < n + 2; j++) {
				
				// add "L" value for every edge array
				if ((i == 0) || (j == 0) || (i == n + 1) || (j == n + 1)) arrA[i][j] = "L";  
				
				// sign inisial value to array from arrays
				else arrA[i][j] = arr[i - 1][j - 1];  
				
		        } 
			
		    }
		
		return arrA;
	}
	
	private static int countGunung(String[][] arr, int n) {
		
		//creating filed for counting "G" or pack "G"
		int count = 0;
		
		//looping for 2 dimension array
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				
				//checking if value equal "G"
				if(arr[i][j].equals("G")) {
					
					//creating node for list "G"
					String temp = i+"-"+j;
					
					//checking if node already in list "G"
					if(listS.contains(i+"-"+j)) {
						
						//checking around node (left, rigth, top, bottom is equal "G"
						//checking top side and add to list if equals "G"
						if(arr[i][j].equals(arr[i - 1][j]) && !listS.contains((i-1)+"-"+j)) listS.add((i-1)+"-"+j);
						
						//checking bottom side add to list if equals "G"
						if(arr[i][j].equals(arr[i + 1][j]) && !listS.contains((i+1)+"-"+j)) listS.add((i+1)+"-"+j); 
						
						//checking left side add to list if equals "G"
						if(arr[i][j].equals(arr[i][j - 1]) && !listS.contains(i+"-"+(j-1))) listS.add(i+"-"+(j-1));
						
						//checking right side add to list if equals "G"
						if(arr[i][j].equals(arr[i][j + 1]) && !listS.contains(i+"-"+(j+1))) listS.add(i+"-"+(j+1)); 
						
					} else {
						
						//creating parameter state for adding list if true or false
						boolean bol = true;
						
						//checking around node already in list "G"
						if(arr[i][j].equals(arr[i - 1][j]) && listS.contains((i-1)+"-"+j)
						|| arr[i][j].equals(arr[i + 1][j]) && listS.contains((i+1)+"-"+j)
						|| arr[i][j].equals(arr[i][j - 1]) && listS.contains(i+"-"+(j-1))
						|| arr[i][j].equals(arr[i][j + 1]) && listS.contains(i+"-"+(j+1))) bol = false;
						
						else {
							
							//checking top side and add node to list "G"
							if(arr[i][j].equals(arr[i - 1][j])) {
								
								//add top side node to list "G"
								listS.add((i-1)+"-"+j);
								
								//check around top side node
								bol = checkAround(arr, i-1, j);
								
								if(bol) {
									
									// add temp node to list "G"
									listS.add(temp);
									
									//count "G" plus 1
									count++;
								}
							}
							
							//checking bottom side and add node to list "G"
							if(arr[i][j].equals(arr[i + 1][j])) {
								
								//add bottom side node to list "G"
								listS.add((i+1)+"-"+j); 
								
								//check around bottom side node
								bol = checkAround(arr, i+1, j);
								
								if(bol) {
									
									// add temp node to list "G"
									listS.add(temp);
									
									//count "G" plus 1
									count++;
								}
							}
							
							// checking left side and add node to list "G"
							if(arr[i][j].equals(arr[i][j - 1])) {
								
								//add left side node to list "G"
								listS.add(i+"-"+(j-1));
								
								// check aroud left side node
								bol = checkAround(arr, i, j-1);
								
								if(bol) {
									
									// add temp node to list "G"
									listS.add(temp);
									
									//count "G" plus 1
									count++;
								}
							}
							
							// checking right side and add node to list "G"
							if(arr[i][j].equals(arr[i][j + 1])) {
								
								// add right side node to list "G"
								listS.add(i+"-"+(j+1));
								
								//check arpund right side node
								bol = checkAround(arr, i, j+1);
								
								if(bol) {
					
									// add temp node to list "G"
									listS.add(temp);
									
									//count "G" plus 1
									count++;
								}
							}
						}	
						
						// check if temp node already in list "G"
						if(bol && !listS.contains(temp)) {
							
							// add temp node to list "G"
							listS.add(temp);
							
							//count "G" plus 1
							count++;
						}
						
					}
				}
			}
		}	
		return count;
	}
	
	private static boolean checkAround(String[][] arr, int i, int j) {
		
		boolean bol = false;
		
		// check top side node 
		if(arr[i][j].equals(arr[i - 1][j]) && !listS.contains((i-1)+"-"+j)) {
			
			// add to list "G"
			listS.add((i-1)+"-"+j);
			
			// for return
			bol = true;
		}
		
		// check bottom side node
		if(arr[i][j].equals(arr[i + 1][j]) && !listS.contains((i+1)+"-"+j)) {
			
			// add to list "G"
			listS.add((i+1)+"-"+j); 
			
			// for return
			bol = true;
		}
		
		// check left side node
		if(arr[i][j].equals(arr[i][j - 1]) && !listS.contains(i+"-"+(j-1))) {
			
			// add to list "G"
			listS.add(i+"-"+(j-1));
			
			// for return
			bol = true;
		}
		
		// check right side node
		if(arr[i][j].equals(arr[i][j + 1]) && !listS.contains(i+"-"+(j+1))) {
			
			// add to list "G"
			listS.add(i+"-"+(j+1));
			
			// for return
			bol = true;
		}
		
		return bol;
	}
	
//	private static int countGunung(String[][] arr) {
//		// TODO Auto-generated method stub
//		int n = arr.length;
//		String param = "";
//		int count = 0;
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				if(!param.equals(arr[i][j])) {
//					param = arr[i][j];
//					if(param.equals("G")) count ++;
//				}
//			}
//		}
//		return count;
//	}
	
	

}
