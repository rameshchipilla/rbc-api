package git.rbc.api.service;

import java.util.List;

import git.rbc.api.model.PetModel;

public interface IPetService {

	public abstract List<PetModel> getAllPets();

	public abstract PetModel getPet(long id);

	public abstract void addUpdatePet(PetModel petModel);

	public abstract void deletePet(long id);
}