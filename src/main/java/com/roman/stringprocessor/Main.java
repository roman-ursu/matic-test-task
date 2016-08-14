package com.roman.stringprocessor;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		StringProcessor processor = new StringProcessor();
		processor.start("aabzcabccaz", Arrays.asList(new String[] {"a","ab","b", "c", "z", "zc"}));
	}

	
	
}
