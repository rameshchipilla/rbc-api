package git.rbc.api.service;

import java.util.Date;
import java.util.List;

import git.rbc.api.model.AppointmentModel;

public interface IAppointmentService {

	public abstract List<AppointmentModel> getAllAppointments();

	public abstract AppointmentModel getAppointment(long id);

	public abstract List<AppointmentModel> getAppointmentsByPetId(long petId);

	public abstract List<AppointmentModel> getAppointmentsByVetId(long vetId);

	public abstract List<AppointmentModel> getAppointmentByVetIdAndDate(long vetId, Date appointmentDate);

	public abstract void addUpdateAppointment(AppointmentModel appointmentModel);

	public abstract void deleteAppointment(long id);

}