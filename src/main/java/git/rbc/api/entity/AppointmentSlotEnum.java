package git.rbc.api.entity;

public enum AppointmentSlotEnum {
	ONE("1"), TWO("2");

	private final String slotText;

	private AppointmentSlotEnum(String slotText) {
		this.slotText = slotText;
	}

	public String getSlotText() {
		return this.slotText;
	}

}
