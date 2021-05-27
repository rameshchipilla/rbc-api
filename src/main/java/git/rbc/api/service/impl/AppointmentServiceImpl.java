package git.rbc.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import git.rbc.api.dao.AppointmentRepository;
import git.rbc.api.entity.AppointmentEntity;
import git.rbc.api.model.AppointmentModel;
import git.rbc.api.model.AppointmentSlotModel;
import git.rbc.api.model.PetModel;
import git.rbc.api.model.VetModel;
import git.rbc.api.service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	public List<AppointmentModel> getAllAppointments() {
		List<AppointmentEntity> appointments = new ArrayList<>();
		appointmentRepository.findAll().forEach(appointments::add);
		return copyToAppointmentModel(appointments);
	}

	public AppointmentModel getAppointment(long id) {
		AppointmentEntity appointment = appointmentRepository.findById(id).orElseGet(AppointmentEntity::new);
		AppointmentModel appointmentModel = new AppointmentModel();
		BeanUtils.copyProperties(appointment, appointmentModel);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		appointmentModel.setPetModel(mapper.convertValue(appointment.getPet(), PetModel.class));
		appointmentModel.setVetModel(mapper.convertValue(appointment.getVet(), VetModel.class));
		appointmentModel
				.setSlotModel(mapper.convertValue(appointment.getAppointmentSlot(), AppointmentSlotModel.class));

		return appointmentModel;
	}

	public List<AppointmentModel> getAppointmentsByPetId(long petId) {
		List<AppointmentEntity> appointments = appointmentRepository.findByPetId(petId);
		return copyToAppointmentModel(appointments);
	}

	public List<AppointmentModel> getAppointmentsByVetId(long vetId) {
		List<AppointmentEntity> appointments = appointmentRepository.findByVetId(vetId);
		return copyToAppointmentModel(appointments);
	}

	public List<AppointmentModel> getAppointmentByVetIdAndDate(long vetId, Date appointmentDate) {
		List<AppointmentEntity> appointments = appointmentRepository.findByVetIdAndAppointmentDate(vetId,
				appointmentDate);
		return copyToAppointmentModel(appointments);
	}

	public void addUpdateAppointment(AppointmentModel appointmentModel) {
		AppointmentEntity appointment = new AppointmentEntity();
		BeanUtils.copyProperties(appointmentModel, appointment);
		appointmentRepository.save(appointment);
	}

	public void deleteAppointment(long id) {
		appointmentRepository.deleteById(id);
	}

	private List<AppointmentModel> copyToAppointmentModel(List<AppointmentEntity> appointments) {
		List<AppointmentModel> appointmentModels = new ArrayList<>();
		for (AppointmentEntity appointment : appointments) {
			AppointmentModel appointmentModel = new AppointmentModel();
			BeanUtils.copyProperties(appointment, appointmentModel);

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			appointmentModel.setPetModel(mapper.convertValue(appointment.getPet(), PetModel.class));
			appointmentModel.setVetModel(mapper.convertValue(appointment.getVet(), VetModel.class));
			appointmentModel
					.setSlotModel(mapper.convertValue(appointment.getAppointmentSlot(), AppointmentSlotModel.class));
			appointmentModels.add(appointmentModel);
		}
		return appointmentModels;
	}
}
