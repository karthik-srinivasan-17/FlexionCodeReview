package com.flexion.coding.challenge.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.flexion.coding.challenge.utilities.*;

public class UnitConversionMain {
	private static final Logger logger = LogManager.getLogger(LoggingMain.class);
	// public static Scanner in;
	private final BufferedReader br;
	private boolean logInput = true;
	private List<String> userInput = new LinkedList<String>();

	public UnitConversionMain() {
		// in = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Asks the user to enter an integer number and returns the user's input <br>
	 * handles locale-dependent thousands separators correctly <br>
	 * allows three tries before raising an unrecoverable error
	 *
	 * @param prompt text to display to the user before input
	 * @return the integer value entered by the user
	 * @throws RuntimeException an unrecoverable error occurred
	 */
	public int getInt(String prompt, int max) {
		int errorCount = 0;
		while (errorCount++ < 3) { // no risk of an infinite loop
			String input = getString(prompt);
			input = input.trim(); // ignore leading and trailing spaces
			input = removeThousandsSeparators(input);
			try {
				int output = Integer.parseInt(input);
				if (output <= 0 || output > max) {
					throw new Exception();
				}
				return output;
			} catch (NumberFormatException e) {
				System.out.println("Invalid number. Try again.");
			} catch (Exception e) {
				System.out.println("Invalid number. Please enter a number between 1 & "+ max);
			}
		}
		// three consecutive failures - time to give up.
		throw new RuntimeException("Repeated invalid user input");
	}

	public boolean isYes(String prompt) {
		int errorCount = 0;
		while (errorCount++ < 3) {
			String input = getString(prompt).toLowerCase().trim();
			if (input.equals("y") || input.equals("yes")) {
				return true;
			}
			if (input.equals("n") || input.equals("no")) {
				return false;
			}
			System.out.println("Error! Answer yes or no  || y or n");
		}
		throw new RuntimeException("Repeated invalid user input");
	}

	/**
	 * Asks the user to enter a string and returns the user's input
	 *
	 * @param prompt text to display to the user before input
	 * @return the string entered by the user
	 * @throws RuntimeException an unrecoverable error occurred
	 */
	public String getString(String prompt) {
		System.out.print(prompt);
		String answer;
		try {
			answer = br.readLine();
			if (logInput) {
				userInput.add(answer); // logInput input
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		if (answer == null) {
			throw new RuntimeException("Unexpected end of input");
		}
		return answer;
	}

	/**
	 * Asks the user to enter a double number and returns the user's input <br>
	 * handles locale-dependent thousands separators correctly <br>
	 * allows three tries before raising an unrecoverable error
	 *
	 * @param prompt text to display to the user before input
	 * @return the double value entered by the user
	 * @throws RuntimeException an unrecoverable error occurred
	 */
	public double getDouble(String prompt) {
		int errorCount = 0;
		while (errorCount++ < 3) { // no risk of an infinite loop
			String input = getString(prompt);
			input = input.trim(); // ignore leading and trailing spaces
			input = removeThousandsSeparators(input);
			try {
				double output = Double.parseDouble(input);
				return output;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.");
			} 
		}
		// three consecutive failures - time to give up.
		throw new RuntimeException("Repeated invalid user input");
	}

	// utility to remove thousands separators before using parseInt or parseDouble
	private static final char G_S = DecimalFormatSymbols.getInstance().getGroupingSeparator();
	private static final char D_S = DecimalFormatSymbols.getInstance().getDecimalSeparator();
	private static final Pattern S_P = Pattern.compile("(\\d)" + G_S + "(\\d\\d\\d)");

	private String removeThousandsSeparators(String s) {
		// remove thousands separators (comma in US/UK, period in France etc)...
		// look for (digit) group separator (digit digit digit)
		// replace with (digit) (digit digit digit)

		// make sure that we do not strip any separators AFTER a decimal for doubles.
		// Note that this has no effect on any string without a decimal.
		int decimalIndex = s.indexOf(D_S);
		if (decimalIndex != -1) {
			return removeThousandsSeparators(s.substring(0, decimalIndex)) + s.substring(decimalIndex);
		}

		String str = S_P.matcher(s).replaceAll("$1$2");
		if (s.equals(str)) {
			return str; // no match.
		}
		return removeThousandsSeparators(str); // match. But is it the only match? Send it through again.
	}

	public static void main(String[] args) {
	
		System.out.println("Welcome to Unit Conversion Checking software");
		UnitConversionMain uc = new UnitConversionMain();

		do {
			try {
			System.out.println("What type of conversion you would like to do :");
			displaySelectionMenu();
			int selection = uc.getInt("Enter numerical value of the above options: ", ConversionType.values().length);
			double givenValue, studentValue;
			int fromMeasureUnit, toMeasureUnit;
			if (selection == 1) {

				
					System.out.println("Select Input Unit of measure");
					displayTemperatureMenu();
					 fromMeasureUnit = uc.getInt("Enter a numerical value of the above options : ",
							Temperature.values().length);

					System.out.println("Target Unit of measure");
					displayTemperatureMenu();
					 toMeasureUnit = uc.getInt("Enter a numerical value of the above options : ",
							Temperature.values().length);

					System.out.println("You selected " + Temperature.values()[fromMeasureUnit - 1] + " to "
							+ Temperature.values()[toMeasureUnit - 1] + " conversion");
					if (fromMeasureUnit == toMeasureUnit) {
						System.out.println(Temperature.values()[fromMeasureUnit - 1] + " to "
								+ Temperature.values()[toMeasureUnit - 1] + " conversion is not supported");
						continue;
					}
					givenValue = uc.getDouble(
							"Enter " + Temperature.values()[fromMeasureUnit - 1] + " Value asked in exam : ");
					studentValue = uc.getDouble(
							"Enter " + Temperature.values()[toMeasureUnit - 1] + " Value student wrote in the exam : ");
			

		

				boolean validate = AnswerChecker.checkTemperature(Temperature.values()[fromMeasureUnit - 1].toString(),
						Temperature.values()[toMeasureUnit - 1].toString(), givenValue, studentValue);
				if (validate) {
					System.out.println(givenValue + " " + Temperature.values()[fromMeasureUnit - 1] + " is equal to "
							+ studentValue + " " + Temperature.values()[toMeasureUnit - 1].toString());
					System.out.println("Student Response is  CORRECT");
				}

				else {
					System.out
							.println(givenValue + " " + Temperature.values()[fromMeasureUnit - 1] + " is not equal to "
									+ studentValue + " " + Temperature.values()[toMeasureUnit - 1].toString());
					System.out.println("Student Response is  INCORRECT ");
				}

			} else {

					System.out.println(" Select Input Unit of measure");
					displayVolumeMenu();
					  fromMeasureUnit= uc.getInt("Enter a numerical value of the above options : ", Volumes.values().length);

					System.out.println("Target Unit of measure");
					displayVolumeMenu();
					 toMeasureUnit = uc.getInt("Enter a numerical value of the above options : ", Volumes.values().length);
					System.out.println("You selected " + Volumes.values()[fromMeasureUnit - 1] + " to "
							+ Volumes.values()[toMeasureUnit - 1] + " conversion");
					if (fromMeasureUnit == toMeasureUnit) {
						System.out.println(Volumes.values()[fromMeasureUnit - 1] + " to "
								+ Volumes.values()[toMeasureUnit - 1] + " conversion is not supported");
						continue;
					}
					givenValue = uc.getDouble(
							"Enter " + Volumes.values()[fromMeasureUnit - 1] + " Value asked in exam : ");
					studentValue = uc.getDouble(
							"Enter " + Volumes.values()[toMeasureUnit - 1] + " Value student wrote in the exam : ");

//				double givenValue = uc
//						.getDouble("Enter " + Volumes.values()[fromMeasureUnit - 1] + " Value asked in exam : ");
//				double studentValue = uc.getDouble(
//						"Enter " + Volumes.values()[toMeasureUnit - 1] + " Value student wrote in the exam : ");
				boolean validate = AnswerChecker.checkVolume(Volumes.values()[fromMeasureUnit - 1].toString(),
						Volumes.values()[toMeasureUnit - 1].toString(), givenValue, studentValue);
				if (validate) {
					System.out.println(givenValue + " " + Volumes.values()[fromMeasureUnit - 1] + " is equal to "
							+ studentValue + " " + Volumes.values()[toMeasureUnit - 1].toString());
					System.out.println("Student Response is  CORRECT");
				}

				else {
					System.out.println(givenValue + " " + Volumes.values()[fromMeasureUnit - 1] + " is not equal to "
							+ studentValue + " " + Volumes.values()[toMeasureUnit - 1].toString());
					System.out.println("Student Response is  INCORRECT ");
				}

			}
			} catch (RuntimeException ex) {
				System.out.println("Too Many Invalid Inputs - Starting from the begining");
				continue;
			}

		} while (uc.isYes("Do you want to enter Another conversion ? (Enter Y or N) : "));

		System.out.println("Thanks for using Unit Conversion Checking software");
		return;
	}

	public static void displaySelectionMenu() {
		for (int i = 0; i < ConversionType.values().length; i++) {
			System.out.println(i + 1 + "." + ConversionType.values()[i] + " conversion");
		}
	}

	public static void displayTemperatureMenu() {
		for (int i = 0; i < Temperature.values().length; i++) {
			System.out.println(i + 1 + "." + Temperature.values()[i]);
		}
	}

	public static void displayVolumeMenu() {
		for (int i = 0; i < Volumes.values().length; i++) {
			System.out.println(i + 1 + "." + Volumes.values()[i]);
		}
	}

}
