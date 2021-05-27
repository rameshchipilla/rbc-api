package git.rbc.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.rbc.api.dao.PetRepository;
import git.rbc.api.entity.PetEntity;
import git.rbc.api.model.PetModel;
import git.rbc.api.service.IPetService;

@Service
public class PetServiceImpl implements IPetService {

	@Autowired
	private PetRepository petRepository;

	public List<PetModel> getAllPets() {
		List<PetEntity> pets = new ArrayList<>();
		petRepository.findAll().forEach(pets::add);

		List<PetModel> petModels = new ArrayList<>();
		for (PetEntity pet : pets) {
			PetModel petModel = new PetModel();
			BeanUtils.copyProperties(pet, petModel);
			petModels.add(petModel);
		}
		return petModels;
	}

	public PetModel getPet(long id) {
		PetModel petModel = null;
		Optional<PetEntity> value = petRepository.findById(id);
		if (value.isPresent()) {
			petModel = new PetModel();
			BeanUtils.copyProperties(value.get(), petModel);
		}
		return petModel;
	}

	public void addUpdatePet(PetModel petModel) {
		PetEntity pet = new PetEntity();
		BeanUtils.copyProperties(petModel, pet);
		petRepository.save(pet);
	}

	public void deletePet(long id) {
		petRepository.deleteById(id);
	}
}