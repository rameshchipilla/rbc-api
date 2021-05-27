package git.rbc.api.service;

import java.util.List;

import git.rbc.api.model.VetModel;

public interface IVetService {

	public abstract List<VetModel> getAllVets();

	public abstract VetModel getVet(long id);

	public abstract void addUpdateVet(VetModel vetModel);

	public abstract void deleteVet(long id);

}