package tests;

public class Normalisation {
	
	public static String Pays(String input) {
		if(input == "letzebuerg") {
			return "Luxembourg";
		}
		
		if(input == "belgium") {
			return "Belgique";
		}
		
		if(input == "Switzerland" || input == "Schweiz") {
			return "Suisse";
		}
		return input;
	}
	
	public static String Ville(String input) {
		String result = "";
		String[] array = input.split(" ");
		
		for(String el : array) {
			
			if(!el.matches("le|lès|sous|sur|à|aux")) {
				
				result += el.substring(0, 1).toUpperCase() + el.substring(1) + "-";
			} else {
				result += el + "-";
			}
		}
		
		return result.substring(0, result.length() - 1);
	}
	
	public static String CodePostal(String input) {
		String result = input;
		
		if(result.matches("[0-9]{1,4}")) {
			for(int i = input.length(); i < 5; i++)
				result = "0" + result;
		}
		
		if(input.matches("[A-Z][-][0-9]{1,5}")) {
			result = result.substring(2);
		}
		return result;
	}
	
	public static String Voie(String input) {
		String result = input;
		
		
		if(result.matches("/boul\\.|bd|boul/g")) {			
			result = result.replaceAll("/boul\\.|bd|boul/g", "boulevard");
		}
		
		if(result.matches("av\\.")) {
			result = result.replaceAll("av\\.", "avenue");
		}
		
		if(result.matches("faub\\.|fg")) {
			result = result.replaceAll("faub\\.|fg", "faubourg");
		}
		
		if(result.matches("pl\\.")) {
			result = result.replaceAll("pl\\.", "place");
		}
		
		return result;
	}
	
	public static String no_voie(String input) {
		String[] s = input.split(" ");
		String result = "";
		
		for(String l : s)
			result += (l == s[0]) ? l + ", " : l + " ";
		
		return result.substring(0, result.length() - 1);
	}
}
