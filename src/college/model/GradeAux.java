package college.model;

public class GradeAux {
	private int gradeAuxId;
	private String letter;
	private int pointsStart;
	private int pointsEnd;

	public int getGradeAuxId() {
		return gradeAuxId;
	}
	public void setGradeAuxId(int gradeAuxId) {
		this.gradeAuxId = gradeAuxId;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public int getPointsStart() {
		return pointsStart;
	}
	public void setPointsStart(int pointsStart) {
		this.pointsStart = pointsStart;
	}
	public int getPointsEnd() {
		return pointsEnd;
	}
	public void setPointsEnd(int pointsEnd) {
		this.pointsEnd = pointsEnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gradeAuxId;
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
		GradeAux other = (GradeAux) obj;
		if (gradeAuxId != other.gradeAuxId)
			return false;
		return true;
	}
}
