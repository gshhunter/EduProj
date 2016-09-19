package com.malihong.util;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {

	/**
	 * Get a list from random numbers
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> getRandomNumber(int size) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		int i=0;
		for ( ;i<5; ) {
			int number = random.nextInt(size);
			if (!list.contains(number)) {
				list.add(number);
				i++;
			}
		}
		
		return list;
	}
}
