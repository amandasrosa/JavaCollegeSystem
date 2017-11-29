package college.model;

public enum Status {
	Active(1),
	Inactive(2);

	private final int code;

	private Status(int code) {
		this.code = code;
	}

	public int toInt() {
		return code;
	}
}
