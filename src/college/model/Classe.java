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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classe other = (Classe) obj;
		if (classeId != other.classeId)
			return false;
		return true;
	}
}
