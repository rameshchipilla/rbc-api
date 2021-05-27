package git.rbc.api.model;

public class AppointmentSlotModel extends BaseModel {

	private static final long serialVersionUID = -1546672924599106752L;

	private String slotText;
	private boolean active;

	public String getSlotText() {
		return slotText;
	}

	public void setSlotText(String slotText) {
		this.slotText = slotText;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
