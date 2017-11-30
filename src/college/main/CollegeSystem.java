package college.main;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import college.controller.CollegeController;
import college.model.College;
import college.model.Employee;
import college.model.Function;

public class CollegeSystem {
	private static Scanner scanner;
	private static Employee instructor;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("\nCollege System\n");
			System.out.println("1: Load data files");
			System.out.println("2: Save data files");
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
		College college = new College();
		college.createCollege();
		System.out.println("\nFiles loaded. Press <ENTER> to return to main menu:");
		waitEnter();
	}
	
	private static void saveFiles() {
		System.out.println("\nSaving data files...");
		waitEnter();
	}
	
	private static void generateReports() {
		while (true) {
			System.out.println("\nChoose a report\n");
			System.out.println("1: Instructors by classes and average student grades");
			System.out.println("2: Number of students by country");
			System.out.println("3: Top 3 courses with worst average grades");
			System.out.println("4: Number of classes per instructor per weekday");
			System.out.println("4: Top student with best average grade by program");
			System.out.println("0: Return to main menu");
			String option = readInputWithMessage("Please select one option:", "0", "1", "2", "3", "4", "5");
			switch (option) {
				case "0":
					return;
				case "1":
					CollegeController.instructorsByClasses();
					break;
				case "2":
					CollegeController.studentsByCountry();
					break;
				case "3":
					CollegeController.coursesByWorstAverage();
					break;
				case "4":
					CollegeController.classesByInscructorsPerWeek();
					break;
				case "5":
					CollegeController.studentsByBestAverage();
					break;
			}
		}
	}
	
	private static void login() {
		instructor = null;
		while (true) {
			System.out.println("\nType the instructor's employee ID or 0 to return to the main menu:\n");
			String option = readInput();
			if (option.equals("0")) {
				return;
			}
			if (College.getEmployees() == null) {
				System.out.println("There is no data in the system. Please load the data files first.");
				System.out.println("Press <ENTER> to return to main menu:");
				waitEnter();
				return;
			}
			int id = 0;
			try {
				id = Integer.parseInt(option);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number. Try again.");
				continue;
			}
			for (Employee e: College.getEmployees()) {
				if (e.getEmployeeId() == id && (e.getMainFunction() == Function.Instructor ||
						e.getMainFunction() == Function.Head)) {
					instructor = e;
					break;
				}
			}
			if (instructor == null) {
				System.out.println("There is no intructor with the employee ID " + option);
			} else {
				instructorMenu();
				return;
			}
		}
	}

	private static void instructorMenu() {
		while (true) {
			System.out.println("\nWelcome " + instructor.getName() + "!\n");
			System.out.println("Menu");
			System.out.println("1: View classes");
			System.out.println("2: View students");
			System.out.println("0: Return to main menu");
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
		System.out.println("\nClasses of instructor " + instructor.getName() + ":\n");
		waitEnter();
	}
	
	private static void viewStudents() {
		System.out.println("\nStudents of instructor " + instructor.getName() + ":\n");
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
