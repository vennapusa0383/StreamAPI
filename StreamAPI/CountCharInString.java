package com.alt;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountCharInString {
	public static void main(String[] args) {
		String input = "string data to count each character";
		findCountOfChars(input);
	}
	
	public static void findCountOfChars(String s) {
		Map<String, Long> map = Arrays.stream(s.split(""))
		                              .map(String::toLowerCase)
		                              .collect(Collectors
		                              .groupingBy(str -> str, 
		                                LinkedHashMap::new, Collectors.counting()));
		}

}
