package college.model;

import java.util.Date;

public class Student {
	private int studentId;
    private String name;
    private Country originCountry;
    private Date startDate;
    private Date endDate;
    private Status status;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(Country originCountry) {
		this.originCountry = originCountry;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
    
}
