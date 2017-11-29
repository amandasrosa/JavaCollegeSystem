package college.main;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CollegeSystem {
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nCollege System - Instructor View\n");
			System.out.println("Menu");
			System.out.println("1: Load Files");
			System.out.println("2: Save Data in Files");
			System.out.println("3: View classes");
			System.out.println("0: Exit");
			String option = readInputWithMessage(
					"Please select one option:", "0", "1", "2", "3");
			if (option.equals("0")) {
				System.out.println("End of program.");
				System.exit(0);
			} else if (option.equals("1")) {
				loadFiles();
			} else if (option.equals("2")) {
				saveFiles();
			} else {
				viewClasses();
			}
		}

	}

	private static String readInput() {
		String line = "";
		try {
			while (line.isEmpty()) {
				line = scanner.nextLine().trim();
			}
		} catch(IllegalStateException | NoSuchElementException e) {
			System.out.println("System.in was closed; exiting");
			System.exit(0);
		}
		return line;
	}

	private static void waitEnter() {
		try {
			scanner.nextLine();
		} catch(IllegalStateException | NoSuchElementException e) {
			System.out.println("System.in was closed; exiting");
		}
	}
	
	private static String readInputWithMessage(String message, String... options) {
		String option = "";
		List<String> list = Arrays.asList(options);
		do {
			System.out.println(message);
			option = readInput().toLowerCase();
		} while (!list.contains(option));
		return option;
	}
	
	private static void loadFiles() {
		System.out.println("\nLoading data files...");
		waitEnter();
	}
	
	private static void saveFiles() {
		System.out.println("\nSaving data files...");
		waitEnter();
	}
	
	private static void viewClasses() {
		System.out.println("\nClasses of instructor <Instructor>:");
		waitEnter();
	}
}
