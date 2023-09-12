package Pkg.Utiltiy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.qameta.allure.Step;

public class EmailCombinationsGenerator {

	private static List<String> emailCombinations = new ArrayList<>();
	private static int currentIndex = 0;
	@Step("Add the email and index for the email and there combinations for the register on site")
	public static String emailIdAndTheIndexCombinations(String emailIdValue, int indexValue) {
		generateCombinations(emailIdValue);
		String combination = getEmailCombination(indexValue);
		if (combination != null) {
			System.out.println("Using email combination: ");
		} else {
			System.out.println("Please add another email for further automation.");
		}
		int combinationsCount = getEmailCombinationsCount();
		return combination;
	}
	public static int emailIdAndTheIndexCombinationsByIndex(String emailIdValue, int indexValue) {
		generateCombinations(emailIdValue);
		String combination = getEmailCombination(indexValue);
		if (combination != null) {
			System.out.println("Using email combination: ");
		} else {
			System.out.println("Please add another email for further automation.");
		}
		int combinationsCount = getEmailCombinationsCount();
		return combinationsCount;
	}

	public static void main(String[] args) {

		String value=emailIdAndTheIndexCombinations("testuserforautomationm.time@gmail.com",3);
		System.out.println(getEmailCombinationsCount());
		System.out.println(value);
	}

	public static void generateCombinations(String email) {
		String[] parts = email.split("@");
		if (parts.length != 2) {
			System.out.println("Invalid email format");
			return;
		}
		String localPart = parts[0];
		String domain = parts[1];
		Set<String> uniqueCombinations = new HashSet<>();

		// Generate combinations with one, two, or three dots, avoiding dots at the
		// start, end, or consecutive dots
		for (int dots = 1; dots <= 3; dots++) {
			for (int i = 1; i < localPart.length() - 1; i++) {
				for (int j = i + 1; j < localPart.length(); j++) {
					if (localPart.charAt(i) != '.' && localPart.charAt(j) != '.' && localPart.charAt(i - 1) != '.') {
						StringBuilder combination = new StringBuilder(localPart);
						combination.insert(i, '.');
						combination.insert(j + 1, '.');
						String emailCombination = combination.toString() + "@" + domain;
						if (!uniqueCombinations.contains(emailCombination)) {
							emailCombinations.add(emailCombination);
							uniqueCombinations.add(emailCombination);
						}
					}
				}
			}
		}
	}

	public static String getEmailCombination(int index) {
		if (index >= 0 && index < emailCombinations.size()) {
			return emailCombinations.get(index);
		}
		return null;
	}

	public static int getEmailCombinationsCount() {
		return emailCombinations.size();
	}
	
	public static int[][] mainTest() {
	    String emailIdValue = "testuserforautomationm.time@gmail.com";
	    int limitOfTheArray = emailIdAndTheIndexCombinationsByIndex(emailIdValue, 53);
	    int[] a = new int[limitOfTheArray];

	    for (int i = 0; i < limitOfTheArray; i++) {
	        a[i] = i + 1;
	    }

	    int numberOfTestCases = 6;
	    int[] currentIndex = new int[numberOfTestCases];
	    int[][] result = new int[numberOfTestCases][6];

	    for (int testCase = 0; testCase < numberOfTestCases; testCase++) {
	        for (int i = 0; i < 6; i++) {
	            if (currentIndex[testCase] < a.length) {
	                result[testCase][i] = a[currentIndex[testCase]];
	                currentIndex[testCase]++;
	            }
	        }
	    }
	    
	    return result;
	}

}
