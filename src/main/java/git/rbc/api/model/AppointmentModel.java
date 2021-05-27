package git.rbc.api.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentModel extends BaseModel {

	private static final long serialVersionUID = 3187446315560131452L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Los_Angeles")
	private Date appointmentDate;

	private String status;
	private VetModel vetModel;
	private PetModel petModel;
	private AppointmentSlotModel slotModel;

	private Long petId;
	private Long vetId;
	private Long slotId;

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

	public VetModel getVetModel() {
		return vetModel;
	}

	public void setVetModel(VetModel vetModel) {
		this.vetModel = vetModel;
	}

	public PetModel getPetModel() {
		return petModel;
	}

	public void setPetModel(PetModel petModel) {
		this.petModel = petModel;
	}

	public AppointmentSlotModel getSlotModel() {
		return slotModel;
	}

	public void setSlotModel(AppointmentSlotModel slotModel) {
		this.slotModel = slotModel;
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

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

}
