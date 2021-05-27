package git.rbc.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.rbc.api.model.AppointmentSlotModel;
import git.rbc.api.service.IAppointmentSlotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/appointmentslots/v1")
@RestController
@Api("Set of endpoints for retrieving appointment slots ")
public class AppointmentSlotAPIController {

	@Autowired
	private IAppointmentSlotService appointmentSlotService;

	@GetMapping
	@ApiOperation("Returns list of all default appointment slots in the system.")
	public List<AppointmentSlotModel> getDefaultSlots() {
		return appointmentSlotService.getDefaultSlots();
	}
}