package git.rbc.api.service;

import java.util.Date;
import java.util.List;

import git.rbc.api.model.AppointmentSlotModel;

public interface IAppointmentSlotService {

	public abstract List<AppointmentSlotModel> getDefaultSlots();

	public abstract List<AppointmentSlotModel> getAvailableSlotsByVetIdAndDate(Long vetid, Date appointmentDate);

}