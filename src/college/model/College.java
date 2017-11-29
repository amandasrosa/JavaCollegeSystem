package college.model;

import java.util.List;

import college.controller.FileHandler;

public class College {
	private static FileHandler fileHandler = new FileHandler();;
	private static List<Employee> employees;
	private static List<Department> departments;
	private static List<DepartmentEmployee> departmentEmployees;
	private static List<Program> programs;
	private static List<Course> courses;
	private static List<Classe> classes;
	private static List<Student> students;
	private static List<StudentClass> studentClasses;
	private static List<Schedule> schedules;
	private static List<GradeAux> grades;

	public void createCollege () {
		createEmployees();
		createDepartments();
		createDepartmentEmployees();
		createPrograms();
		createCourses();
		createClasses();
		createStudents();
		createStudentClasses();
		createSchedules();
		createGrades();
	}
	public void createEmployees () {
		employees = fileHandler.parseEmployeeJson();
	}
	public void createDepartments () {
		departments = fileHandler.parseDepartmentJson();
	}
	public void createDepartmentEmployees () {
		departmentEmployees = fileHandler.parseDepartmentEmployeeJson();
	}
	public void createPrograms () {
		programs = fileHandler.parseProgramJson();
	}
	public void createCourses () {
		courses = fileHandler.parseCourseJson();
	}
	public void createClasses () {
		classes = fileHandler.parseClasseJson();
	}
	public void createAndInsertClasse () {

	}
	public void createStudents () {
		students = fileHandler.parseStudentJson();
	}
	public void createStudentClasses () {
		studentClasses = fileHandler.parseStudentClassJson();
	}
	public void createAndInsertStudentClass () {

	}
	public void createSchedules () {
		schedules = fileHandler.parseScheduleJson();
	}
	public void createAndInsertSchedule () {

	}
	public void createGrades () {
		grades = fileHandler.parseGradeAuxJson();
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
