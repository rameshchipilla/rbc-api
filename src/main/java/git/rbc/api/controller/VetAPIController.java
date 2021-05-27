package git.rbc.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import git.rbc.api.model.VetModel;
import git.rbc.api.service.IVetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/vets/v1")
@RestController
@Api("Set of endpoints for creating, retrieving, updating & deleting of vets")
public class VetAPIController {

	@Autowired
	private IVetService vetService;

	@GetMapping
	@ApiOperation("Returns list of all vets in the system.")
	@PreAuthorize("hasAuthority('Everyone') || #oauth2.hasScope('email')")
	public List<VetModel> getAllVets() {
		return vetService.getAllVets();
	}

	@GetMapping("/{id}")
	@ApiOperation("Retrieves a vet from the system. 404 if the vet's identifier is not found.")
	public VetModel getVet(@PathVariable Long id) {
		VetModel vetModel = vetService.getVet(id);
		if (null == vetModel) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return vetModel;
	}

	@PostMapping
	@ApiOperation("Creates a new vet in the system.")
	public void addVet(@RequestBody VetModel vetModel) {
		vetService.addUpdateVet(vetModel);
	}

	@PutMapping("/{id}")
	@ApiOperation("Updates a vet in the system. 404 if the vet's identifier is not found.")
	public void updateVet(@PathVariable Long id, @RequestBody VetModel vetModel) {
		vetModel.setId(id);
		vetService.addUpdateVet(vetModel);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Deletes a vet in the system. 404 if the vet's identifier is not found.")
	public void deleteVet(@PathVariable Long id) {
		vetService.deleteVet(id);
	}
}