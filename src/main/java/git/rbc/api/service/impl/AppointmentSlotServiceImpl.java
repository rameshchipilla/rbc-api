package git.rbc.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.rbc.api.dao.AppointmentRepository;
import git.rbc.api.dao.AppointmentSlotRepository;
import git.rbc.api.entity.AppointmentEntity;
import git.rbc.api.entity.AppointmentSlotEntity;
import git.rbc.api.model.AppointmentSlotModel;
import git.rbc.api.service.IAppointmentSlotService;

@Service
public class AppointmentSlotServiceImpl implements IAppointmentSlotService {

	@Autowired
	private AppointmentSlotRepository appointmentSlotRepository;

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public List<AppointmentSlotModel> getDefaultSlots() {

		List<AppointmentSlotEntity> appointmentSlots = new ArrayList<>();
		appointmentSlotRepository.findAll().forEach(appointmentSlots::add);

		List<AppointmentSlotModel> appointmentSlotModels = new ArrayList<>();
		AppointmentSlotModel appointmentSlotModel;
		for (AppointmentSlotEntity appointmentSlot : appointmentSlots) {
			appointmentSlotModel = new AppointmentSlotModel();
			BeanUtils.copyProperties(appointmentSlot, appointmentSlotModel);
			appointmentSlotModels.add(appointmentSlotModel);
		}

		return appointmentSlotModels;
	}

	@Override
	public List<AppointmentSlotModel> getAvailableSlotsByVetIdAndDate(Long vetId, Date appointmentDate) {

		List<AppointmentEntity> bookedAppointments = appointmentRepository.findByVetIdAndAppointmentDate(vetId,
				appointmentDate);

		List<AppointmentSlotEntity> availableSlots = new ArrayList<>();
		appointmentSlotRepository.findAll().forEach(availableSlots::add);

		// Remove booked slot, exclude cancelled slots
		for (AppointmentEntity appointment : bookedAppointments) {
			if (!"Cancelled".equalsIgnoreCase(appointment.getStatus())) {
				availableSlots.remove(appointment.getAppointmentSlot());	
			}
		}

		List<AppointmentSlotModel> availableSlotModels = new ArrayList<>();
		AppointmentSlotModel appointmentSlotModel;
		for (AppointmentSlotEntity appointmentSlot : availableSlots) {
			appointmentSlotModel = new AppointmentSlotModel();
			BeanUtils.copyProperties(appointmentSlot, appointmentSlotModel);
			availableSlotModels.add(appointmentSlotModel);
		}

		return availableSlotModels;
	}

}
