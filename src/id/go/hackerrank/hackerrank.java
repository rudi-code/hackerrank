package id.go.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hackerrank {
	
	public static void main(String[] args) {
		System.out.println("Aa");
		Integer[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
		List<Integer> list = new ArrayList<>();
		for(Integer a : arr) {
			list.add(a);
		}
		Integer typeBird = 0;
		Integer frequency = 0;
		Set<Integer> distinct = new HashSet<>(list);
		for(Integer i : distinct) {
			System.out.println(i +" : "+Collections.frequency(list, i) );
			if(frequency<Collections.frequency(list, i)) {
				typeBird = i;
				frequency = Collections.frequency(list, i);
			}else if (frequency == Collections.frequency(list, i) && typeBird>i) {
				typeBird = i;
			}
		}
		
		System.out.println("typeBird : "+typeBird);
		
		
		
	}

}
