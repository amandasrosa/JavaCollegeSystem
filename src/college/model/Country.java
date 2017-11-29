package college.model;

public enum Country {
	India(1),
	Brazil(2),
	China(3),
	Philippines(4),
	Turkey(5);

	private final int code;

	private Country(int code) {
		this.code = code;
	}

	public int toInt() {
		return code;
	}
}
