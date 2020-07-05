package com.hackerrank.task;

public class TwoDArrays {
	
//public static void main(String[] args) {
		
//		int[][] arr = {
//				{1, 1, 1, 0, 0, 0},
//				{0, 1, 0, 0, 0, 0},
//				{1, 1, 1, 0, 0, 0},
//				{0, 0, 2, 4, 4, 0},
//				{0, 0, 0, 2, 0, 0},
//				{0, 0, 1, 2, 4, 0}
//				};
		
//		int[][] arr = {
//				{1, 1, 1},
//				{2, 1, 1},
//				{1, 1, 1}
//				};
	
//	int[][] arr = {
//			{-1, -1, 0, -9, -2, -2},
//			{-2, -1, -6, -8, -2, -5},
//			{-1, -1, -1, -2, -3, -4},
//			{-1, -9, -2, -4, -4, -5},
//			{-7, -3, -3, -2, -9, -9},
//			{-1, -3, -1, -2, -4, -5}
//			};
//
//	int a = hourglass(arr);
//	System.out.println(a);
		
//	}
	
	public static int hourglass(int[][] arr) {
			int result = 0;
			int length = arr.length;
			//for loop
			for(int n=0; n<length-2; n++){
				int count = 0;
				for(int m=0; m<length-2; m++) {
					int sumAll= 0;
					int iterasi = 0;
					//loop for matrix 3X3
					//get sumALl
					for(int i=n; i<n+3; i++) {
						for(int j=m; j<m+3; j++) {
							
							if(iterasi == 1) {
								if(j==m+1) {
									sumAll += arr[i][j];
								}
							}else {
								sumAll += arr[i][j];
							}
						}
						System.out.println(sumAll);
						iterasi ++;
					}	
					
					System.out.println(n);
					System.out.println(count);
					if(count == 0  && n == 0) result = sumAll;
					else if(result < sumAll) result = sumAll;
					else result = result;
					System.out.println("result  "+result);
					count ++;
				}
				
			}
			return result;
	}

}
