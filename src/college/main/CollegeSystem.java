package college.main;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import college.controller.CollegeController;
import college.controller.FileHandler;
import college.model.*;

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
		FileHandler.objectsToJson();
		System.out.println("\nData saved. Press <ENTER> to return to main menu:");
		waitEnter();
	}
	
	private static void generateReports() {
		while (true) {
			System.out.println("\nChoose a report\n");
			System.out.println("1: Instructors by classes and average student grades");
			System.out.println("2: Number of students by country");
			System.out.println("3: Top 3 courses with worst average grades");
			System.out.println("4: Number of classes per instructor per weekday");
			System.out.println("5: Top student with best average grade by program");
			System.out.println("0: Return to main menu");
			String option = readInputWithMessage("Please select one option:", "0", "1", "2", "3", "4", "5");
			switch (option) {
				case "0":
					return;
				case "1":
					System.out.println("\nInstructors by classes and average student grades\n");
					CollegeController.instructorsByClasses();
					break;
				case "2":
					System.out.println("\nNumber of students by country\n");
					CollegeController.studentsByCountry();
					break;
				case "3":
					System.out.println("\nTop 3 courses with worst average grades\n");
					CollegeController.coursesByWorstAverage();
					break;
				case "4":
					System.out.println("\nNumber of classes per instructor per weekday\n");
					CollegeController.classesByInscructorsPerWeek();
					break;
				case "5":
					System.out.println("\nTop student with best average grade by program\n");
					CollegeController.studentsByBestAverage();
					break;
			}
			System.out.println("\nPress <ENTER> to return to report menu:");
			waitEnter();
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
			System.out.println("1: View profile");
			System.out.println("2: View classes");
			System.out.println("0: Return to main menu");
			String option = readInputWithMessage("Please select one option:", "0", "1", "2");
			switch (option) {
				case "0":
					return;
				case "1":
					viewProfile();
					break;
				case "2":
					viewClasses();
					break;
			}
		}
	}

	private static void viewProfile() {
		System.out.println("\nInstructor profile:\n");
		System.out.println("Employee ID: " + instructor.getEmployeeId());
		System.out.println("Name: " + instructor.getName());
		System.out.println("Main function: " + instructor.getMainFunction());
		System.out.println("Start date: " + Util.convertDateToString(instructor.getStartDate()));
		System.out.println("\nPress <ENTER> to return to instructor menu:");
		waitEnter();
	}

	private static void viewClasses() {
		while (true) {
			System.out.println("\nClasses of instructor " + instructor.getName() + ":\n");
			List<Classe> classes = CollegeController.getClassesOfInstructor(instructor);
			if (classes.isEmpty()) {
				System.out.println("This instructor teaches no classes in the moment.");
				System.out.println("\nPress <ENTER> to return to instructor menu:");
				waitEnter();
				return;
			}
			for (Classe c: classes) {
				System.out.println("Class ID " + c.getClasseId() + ": " + c.getCourse().getName());				
			}
			while (true) {
				System.out.println("\nType a class ID to see details or 0 to return to instructor menu:");
				String option = readInput();
				if (option.equals("0")) {
					return;
				}
				int id = 0;
				try {
					id = Integer.parseInt(option);
				} catch (NumberFormatException e) {
					System.out.println("Invalid number. Try again.");
					continue;
				}
				Classe classe = null;
				for (Classe c: classes) {
					if (c.getClasseId() == id) {
						classe = c;
						break;
					}
				}
				if (classe == null) {
					System.out.println("This instructor has no class with the ID " + option);
				} else {
					classDetails(classe);
					break;
				}
			}
		}
	}
	
	private static void classDetails(Classe classe) {
		while (true) {
			System.out.println("\nClass details:\n");
			System.out.println("Class ID: " + classe.getClasseId());
			System.out.println("Credits: " + classe.getCourse().getCreditHour());
			System.out.println("Course: " + classe.getCourse().getName());
			System.out.println("Program: " + classe.getCourse().getProgram().getName());
			System.out.println("Department: " + classe.getCourse().getProgram().getDepartment().getName());
			System.out.println("Students:\n");
			for (StudentClass sc: CollegeController.getStudentClassesOfClasse(classe)) {
				System.out.println("ID: " + sc.getStudent().getStudentId() + " - "
						+ sc.getStudent().getName());
			}
			while (true) {
				System.out.println("\nType a student ID to see the activities grades or 0 to return to classes menu:");
				String option = readInput();
				if (option.equals("0")) {
					return;
				}
				int id = 0;
				try {
					id = Integer.parseInt(option);
				} catch (NumberFormatException e) {
					System.out.println("Invalid number. Try again.");
					continue;
				}
				StudentClass studentClass = null;
				for (StudentClass sc: CollegeController.getStudentClassesOfClasse(classe)) {
					if (sc.getStudent().getStudentId() == id) {
						studentClass = sc;
						break;
					}
				}
				if (studentClass == null) {
					System.out.println("In this class, there is no student with the ID " + option);
				} else {
					viewStudentGrades(studentClass);
					break;
				}
			}
		}
	}

	private static void viewStudentGrades(StudentClass studentClass) {
		while (true) {
			System.out.println("\nStudent " + studentClass.getStudent().getName() + " grades:\n");
			System.out.println("1 - Assignment: " + studentClass.getGradeAssig());
			System.out.println("2 - Test: " + studentClass.getGradeTest());
			System.out.println("3 - Project: " + studentClass.getGradeProject() + "\n");
			String option = readInputWithMessage(
					"Type an activity number to change the grade or 0 to return to class details:",
					"0", "1", "2", "3");
			if (option.equals("0")) {
				return;
			}
			while (true) {
				System.out.println("Type the new grade between 0 and 100 or -1 to cancel:");
				String newGrade = readInput();
				if (newGrade.equals("-1")) {
					break;
				}
				int grade = 0;
				try {
					grade = Integer.parseInt(newGrade);
					if (grade < 0 || grade > 100) {
						throw new NumberFormatException();
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid number. Try again.");
					continue;
				}
				switch (option) {
					case "1":
						studentClass.setGradeAssig(grade);
						break;
					case "2":
						studentClass.setGradeTest(grade);
						break;
					case "3":
						studentClass.setGradeProject(grade);
						break;
				}
				break;
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
}
