package git.rbc.api.controller;

import java.util.List;

import javax.validation.constraints.Min;

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

import git.rbc.api.model.PetModel;
import git.rbc.api.service.IPetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/pets/v1")
@RestController
@Api("Set of endpoints for creating, retrieving, updating & deleting of pets")
public class PetAPIController {

	@Autowired
	private IPetService petService;

	@GetMapping
	@ApiOperation("Returns list of all pets in the system.")
	@PreAuthorize("hasAuthority('Everyone') || #oauth2.hasScope('email')")
	public List<PetModel> getAllPets() {
		return petService.getAllPets();
	}

	@PostMapping
	@ApiOperation("Creates a new pet in the system.")
	public void addPet(@RequestBody PetModel petModel) {
		petService.addUpdatePet(petModel);
	}

	@GetMapping("/{id}")
	@ApiOperation("Retrieves a pet from the system. 404 if the pet's identifier is not found.")
	public PetModel getPet(@PathVariable @Min(1) Long id) {
		PetModel petModel = petService.getPet(id);
		if (null == petModel) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return petModel;
	}

	@PutMapping("/{id}")
	@ApiOperation("Updates a pet in the system. 404 if the pet's identifier is not found.")
	public void updatePet(@PathVariable @Min(1) Long id, @RequestBody PetModel petModel) {
		petModel.setId(id);
		petService.addUpdatePet(petModel);
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Deletes a pet in the system. 404 if the pet's identifier is not found.")
	public void deletePet(@PathVariable @Min(1) Long id) {
		petService.deletePet(id);
	}
}