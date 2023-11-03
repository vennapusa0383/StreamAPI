package com.alt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortValues {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 2, 4, 9, 7 };
		Arrays.parallelSort(arr);
		Arrays.stream(arr).forEach(x -> System.out.println(x));

		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		//Sort values Descending Order
		myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
	}

}
