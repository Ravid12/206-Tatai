package application.utils;

import java.util.ArrayList;

public class MaoriUtils {
	public static String getMaoriNumber(int number) {
		
		final String[] components = new String[] {
				"maa",
				"tahi",
				"rua",
				"toru",
				"wha",
				"rima",
				"ono",
				"whitu",
				"waru",
				"iwa",
				"tekau"
		};
		
		if (number < 11) {
			return components[number];
		} else if (number < 20){
			return components[10] + " " + components[0] + " " + components[number%10];
		} else {
			if (number % 10 == 0) {
				return components[(number/10)%10] + " " + components[10];
			} else {
				return components[((number-number%10)/10)%10] + " " + components[10] + " " + components[0] + " " + components[number%10]; 
			}
		}
	}
}
