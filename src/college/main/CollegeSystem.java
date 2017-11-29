package college.main;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import college.model.Employee;

public class CollegeSystem {
	private static Scanner scanner;
	Employee instructor;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\nCollege System\n");
			System.out.println("1: Load Files");
			System.out.println("2: Save Data in Files");
			System.out.println("3: Generate reports");
			System.out.println("4: Instructor login");
			System.out.println("0: Exit");
			String option = readInputWithMessage("Please select one option:", "0", "1", "2", "3", "4");
			switch (option) {
				case "0":
					System.out.println("End of program.");
					System.exit(0);
					break;
				case "1":
					loadFiles();
					break;
				case "2":
					saveFiles();
					break;
				case "3":
					generateReports();
					break;
				case "4":
					login();
					break;
			}
		}
	}
	
	private static void loadFiles() {
		System.out.println("\nLoading data files...");
		waitEnter();
	}
	
	private static void saveFiles() {
		System.out.println("\nSaving data files...");
		waitEnter();
	}
	
	private static void generateReports() {
		System.out.println("\nChoose a report:");
		waitEnter();
	}
	
	private static void login() {
		while (true) {
			System.out.println("\nType the instructor's employee ID or 0 to return to main menu:\n");
			String id = readInput();
			if (id.equals("0")) {
				return;
			}
			// TODO: search the id and retrieve the instructor
			instructorMenu();
		}
	}

	private static void instructorMenu() {
		while (true) {
			System.out.println("\nInstructor Menu\n");
			System.out.println("Menu");
			System.out.println("1: View classes");
			System.out.println("2: View students");
			System.out.println("0: Return to instructor's selection");
			String option = readInputWithMessage("Please select one option:", "0", "1", "2");
			switch (option) {
				case "0":
					return;
				case "1":
					viewClasses();
					break;
				case "2":
					viewStudents();
					break;
			}
		}
	}

	private static void viewClasses() {
		System.out.println("\nClasses of instructor <Instructor>:");
		waitEnter();
	}
	
	private static void viewStudents() {
		System.out.println("\nStudents of instructor <Instructor>:");
		waitEnter();
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
}
