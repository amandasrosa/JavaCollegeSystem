package college.model;

public class Course {
	private int courseId;
	private String name;
	private Employee head;
	private int creditHour;
	private Program program;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee getHead() {
		return head;
	}
	public void setHead(Employee head) {
		this.head = head;
	}
	public int getCreditHour() {
		return creditHour;
	}
	public void setCreditHour(int creditHour) {
		this.creditHour = creditHour;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	
}
