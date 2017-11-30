package college.model;

public class StudentClass {
	private int studentClassId;
	private Classe classe;
	private Student student;
	private Integer gradeAssig;
	private Integer gradeTest;
	private Integer gradeProject;

	public int getStudentClassId() {
		return studentClassId;
	}
	public void setStudentClassId(int studentClassId) {
		this.studentClassId = studentClassId;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Integer getGradeAssig() {
		return gradeAssig;
	}
	public void setGradeAssig(Integer gradeAssig) {
		this.gradeAssig = gradeAssig;
	}
	public Integer getGradeTest() {
		return gradeTest;
	}
	public void setGradeTest(Integer gradeTest) {
		this.gradeTest = gradeTest;
	}
	public Integer getGradeProject() {
		return gradeProject;
	}
	public void setGradeProject(Integer gradeProject) {
		this.gradeProject = gradeProject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentClassId;
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
		StudentClass other = (StudentClass) obj;
		if (studentClassId != other.studentClassId)
			return false;
		return true;
	} 
}
