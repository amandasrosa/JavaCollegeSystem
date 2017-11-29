package college.model;

public class StudentClass {
	private int studentClassId;
    private Classe classe;
    private Student student;
    private int gradeAssig;
    private int gradeTest;
    private int gradeProject;
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
	public int getGradeAssig() {
		return gradeAssig;
	}
	public void setGradeAssig(int gradeAssig) {
		this.gradeAssig = gradeAssig;
	}
	public int getGradeTest() {
		return gradeTest;
	}
	public void setGradeTest(int gradeTest) {
		this.gradeTest = gradeTest;
	}
	public int getGradeProject() {
		return gradeProject;
	}
	public void setGradeProject(int gradeProject) {
		this.gradeProject = gradeProject;
	}
    
}
