package git.rbc.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.rbc.api.model.AppointmentModel;
import git.rbc.api.model.AppointmentSlotModel;
import git.rbc.api.service.IAppointmentService;
import git.rbc.api.service.IAppointmentSlotService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/appointments/v1")
@RestController
@Api("Set of endpoints for creating, retrieving, updating & deleting of appointments")
@CrossOrigin
public class AppointmentAPIController {

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private IAppointmentSlotService appointmentSlotService;

	@GetMapping
	@ApiOperation("Returns list of all appointments in the system.")
	public List<AppointmentModel> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	@GetMapping("/{id}")
	@ApiOperation("Retrieves an appointment from the system. 404 if the appointment's identifier is not found.")
	public AppointmentModel getAppointment(@PathVariable Long id) {
		return appointmentService.getAppointment(id);
	}

	@GetMapping("/petid={petId}")
	@ApiOperation("Retrieves list of appointments for the pet from the system. 404 if the pet's identifier is not found.")
	public List<AppointmentModel> getAppointmentsByPetId(@PathVariable Long petId) {
		return appointmentService.getAppointmentsByPetId(petId);
	}

	@GetMapping("/vetid={vetId}")
	@ApiOperation("Retrieves list of appointments for the vet from the system. 404 if the vet's identifier is not found.")
	public List<AppointmentModel> getAppointmentsByVetId(@PathVariable Long vetId) {
		return appointmentService.getAppointmentsByVetId(vetId);
	}

	@PostMapping
	@ApiOperation("Creates a new appointment in the system.")
	public void addAppointment(@RequestBody AppointmentModel appointmentModel) {
		appointmentService.addUpdateAppointment(appointmentModel);
	}

	@PutMapping("/{id}")
	@ApiOperation("Updates an appointment in the system. 404 if the appointment's identifier is not found.")
	public void updateAppointment(@PathVariable Long id, @RequestBody AppointmentModel appointmentModel) {
		appointmentModel.setId(id);
		appointmentService.addUpdateAppointment(appointmentModel);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Deletes an appointment in the system. 404 if the appointment's identifier is not found.")
	public void deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
	}

	@GetMapping("/slots/vetid={vetId}/date={date}")
	@ApiOperation("Retrieves list of availabe appointment slots for the vet & for the date from the system. 404 if the vet's identifier is not found.")
	public List<AppointmentSlotModel> getAppointmentSlotsByVetIdAndDate(@PathVariable Long vetId,
			@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return appointmentSlotService.getAvailableSlotsByVetIdAndDate(vetId, date);
	}
}
