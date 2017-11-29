package college.model;

public class Program {
	private int programId;
	private String name;
	private Employee head;
	private Department department;
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
