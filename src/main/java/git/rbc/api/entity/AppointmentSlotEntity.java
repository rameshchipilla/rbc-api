package git.rbc.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "APPOINTMENT_SLOT")
public class AppointmentSlotEntity extends BaseEntity {

	private static final long serialVersionUID = 7618402791303514091L;

	@NotNull
	@Size(max = 50)
	@Column(name = "SLOT_TEXT")
	private String slotText;

	@NotNull
	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "LAST_UPDATE_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = true)
	private Date lastUpdateTs = new Date();

	@Column(name = "CREATION_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createTs;

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

	public Date getLastUpdateTs() {
		return lastUpdateTs;
	}

	public void setLastUpdateTs(Date lastUpdateTs) {
		this.lastUpdateTs = lastUpdateTs;
	}

	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
}
