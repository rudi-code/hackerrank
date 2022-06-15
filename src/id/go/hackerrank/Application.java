package id.go.hackerrank;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
	
	public static void main(String[] args) {
		
//		DayOfProgrammerLeapYear day = new DayOfProgrammerLeapYear();
//		String getDay = day.getDayProggrammer(2017);
//		System.out.println(getDay);
		
		int[][] matrix = {{5,3,4},{1,5,8},{5,4,2}};
		
		getMagic(matrix);
		
		
	}

	private static void getMagic(int[][] arr) {
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i = 0 ; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				if (i==0) a += arr[i][j];
				else if(i==1) b+= arr[i][j];
				else c+= arr[i][j];
			}
		}
	}

	

	
	

}
