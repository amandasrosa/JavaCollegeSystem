package college.model;

public class Classe {
	private int classeId;
	private Course course;
	private Employee instructor;
	public int getClasseId() {
		return classeId;
	}
	public void setClasseId(int classeId) {
		this.classeId = classeId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Employee getInstructor() {
		return instructor;
	}
	public void setInstructor(Employee instructor) {
		this.instructor = instructor;
	}
	
	
}
