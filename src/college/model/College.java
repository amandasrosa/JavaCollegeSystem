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
	
	public void createCollege () {
		createEmployees();
		createDepartments();
		createDepartmentEmployees();
		createPrograms();
		createCourses();
		createStudents();
		createStudentClasses();
		createSchedules();
	}
	public void createEmployees () {
		employees = fileHandler.parseEmployeeJson();
	}
	public void createDepartments () {
		
	}
	public void createDepartmentEmployees () {
			
	}
	public void createPrograms () {
		
	}
	public void createCourses () {
		
	}
	public void createClasses () {
		
	}
	public void createAndInsertClasse () {
		
	}
	public void createStudents () {
		
	}
	public void createStudentClasses () {
			
	}
	public void createAndInsertStudentClass () {
		
	}
	public void createSchedules () {
		
	}
	public void createAndInsertSchedule () {
		
	}

	public static List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public static List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public static List<DepartmentEmployee> getDepartmentEmployees() {
		return departmentEmployees;
	}
	public void setDepartmentEmployees(List<DepartmentEmployee> departmentEmployees) {
		this.departmentEmployees = departmentEmployees;
	}
	public static List<Program> getPrograms() {
		return programs;
	}
	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
	public static List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public static List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	public static List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public static List<StudentClass> getStudentClasses() {
		return studentClasses;
	}
	public void setStudentClasses(List<StudentClass> studentClasses) {
		this.studentClasses = studentClasses;
	}
	public static List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
}
