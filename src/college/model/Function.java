package college.model;

public enum Function {
	Staff(1),
	Head(2),
	Instructor(3);
	
	private final int code;

    private Function(int code) {
        this.code = code;
    }

    public int toInt() {
        return code;
    }
}
