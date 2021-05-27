package git.rbc.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "APPOINTMENT")
public class AppointmentEntity extends BaseEntity {

	private static final long serialVersionUID = -5963298206378751743L;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "APPOINTMENT_DATE")
	@Temporal(TemporalType.DATE)
	private Date appointmentDate;

	@Column(name = "LAST_UPDATE_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = true)
	private Date lastUpdateTs = new Date();

	@Column(name = "CREATION_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createTs;

	@ManyToOne
	@JoinColumn(name = "SLOT_ID", insertable = false, updatable = false)
	private AppointmentSlotEntity appointmentSlot;

	@ManyToOne
	@JoinColumn(name = "PET_ID", insertable = false, updatable = false)
	private PetEntity pet;

	@ManyToOne
	@JoinColumn(name = "VET_ID", insertable = false, updatable = false)
	private VetEntity vet;

	@Column(name = "SLOT_ID")
	private Long slotId;

	@Column(name = "PET_ID")
	private Long petId;

	@Column(name = "VET_ID")
	private Long vetId;

	@PreUpdate
	protected void onUpdate() {
		lastUpdateTs = new Date();
	}

	public PetEntity getPet() {
		return pet;
	}

	public void setPet(PetEntity pet) {
		this.pet = pet;
	}

	public VetEntity getVet() {
		return vet;
	}

	public void setVet(VetEntity vet) {
		this.vet = vet;
	}

	public AppointmentSlotEntity getAppointmentSlot() {
		return appointmentSlot;
	}

	public void setAppointmentSlot(AppointmentSlotEntity appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public Long getVetId() {
		return vetId;
	}

	public void setVetId(Long vetId) {
		this.vetId = vetId;
	}

}