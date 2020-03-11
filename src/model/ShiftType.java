package model;

public class ShiftType {
	private String name;
	private double time;
	private ShiftType nextShiftType;
	
	public ShiftType(String n, double t) {
		name = n;
		time = t;
	}

	public ShiftType getNextShiftType() {
		return nextShiftType;
	}

	public void setNextShiftType(ShiftType nextShiftType) {
		this.nextShiftType = nextShiftType;
	}

	public String getName() {
		return name;
	}

	public double getTime() {
		return time;
	}
}
