package application.utils;

public class MaoriUtils {
	/**
	 * Method that translates an integer input to the corresponding string in Maori.
	 */
	public static String getMaoriNumber(int number) {
		String maoriNumber;
		
		
		final String[] components = new String[] {
				"maa",
				"tahi",
				"rua",
				"toru",
				"whaa",
				"rima",
				"ono",
				"whitu",
				"waru",
				"iwa",
				"tekau"
		};
		
		if (number < 11) {
			maoriNumber = components[number];
		} else if (number < 20){
			maoriNumber = components[10] + " " + components[0] + " " + components[number%10];
		} else {
			if (number % 10 == 0) {
				maoriNumber = components[(number/10)%10] + " " + components[10];
			} else {
				maoriNumber = components[((number-number%10)/10)%10] + " " + components[10] + " " + components[0] + " " + components[number%10]; 
			}
		}
		
		return maoriNumber;
	}
	
	public static String getMaoriNumber(String number) {
		return getMaoriNumber(Integer.parseInt(number));
	}

}
