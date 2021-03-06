package college.model;

import java.util.List;

import college.controller.FileHandler;

public class College {
	private static FileHandler fileHandler = new FileHandler();;
	private static List<Employee> employees = null;
	private static List<Department> departments = null;
	private static List<DepartmentEmployee> departmentEmployees = null;
	private static List<Program> programs = null;
	private static List<Course> courses = null;
	private static List<Classe> classes = null;
	private static List<Student> students = null;
	private static List<StudentClass> studentClasses = null;
	private static List<Schedule> schedules = null;
	private static List<GradeAux> grades = null;

	public void createCollege () {
		employees = fileHandler.parseEmployeeJson();
		departments = fileHandler.parseDepartmentJson();
		departmentEmployees = fileHandler.parseDepartmentEmployeeJson();
		programs = fileHandler.parseProgramJson();
		courses = fileHandler.parseCourseJson();
		classes = fileHandler.parseClasseJson();
		students = fileHandler.parseStudentJson();
		studentClasses = fileHandler.parseStudentClassJson();
		schedules = fileHandler.parseScheduleJson();
		grades = fileHandler.parseGradeAuxJson();
	}
	public void saveCollege () {
		fileHandler.saveEmployeeToJson(employees);
		fileHandler.saveDepartmentToJson(departments);
		fileHandler.saveDepartmentEmployeeToJson(departmentEmployees);
		fileHandler.saveProgramToJson(programs);
		fileHandler.saveCourseToJson(courses);
		fileHandler.saveClasseToJson(classes);
		fileHandler.saveStudentToJson(students);
		fileHandler.saveStudentClassToJson(studentClasses);
		fileHandler.saveScheduleToJson(schedules);
		fileHandler.saveGradeAuxToJson(grades);
	}
	public static List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		College.employees = employees;
	}
	public static List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		College.departments = departments;
	}
	public static List<DepartmentEmployee> getDepartmentEmployees() {
		return departmentEmployees;
	}
	public void setDepartmentEmployees(List<DepartmentEmployee> departmentEmployees) {
		College.departmentEmployees = departmentEmployees;
	}
	public static List<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(List<Program> programs) {
		College.programs = programs;
	}
	public static List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		College.courses = courses;
	}
	public static List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		College.classes = classes;
	}
	public static List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		College.students = students;
	}
	public static List<StudentClass> getStudentClasses() {
		return studentClasses;
	}
	public void setStudentClasses(List<StudentClass> studentClasses) {
		College.studentClasses = studentClasses;
	}
	public static List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		College.schedules = schedules;
	}
	public static List<GradeAux> getGrades() {
		return grades;
	}
	public void setGrades(List<GradeAux> grades) {
		College.grades = grades;
	}
}
