package git.rbc.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import git.rbc.api.dao.VetRepository;
import git.rbc.api.entity.VetEntity;
import git.rbc.api.model.VetModel;
import git.rbc.api.service.IVetService;

@Service
public class VetServiceImpl implements IVetService{

	@Autowired
	private VetRepository vetRepository;

	public List<VetModel> getAllVets() {

		List<VetEntity> vets = new ArrayList<>();
		vetRepository.findAll().forEach(vets::add);

		List<VetModel> vetModels = new ArrayList<>();
		for (VetEntity vet : vets) {
			VetModel vetModel = new VetModel();
			BeanUtils.copyProperties(vet, vetModel);
			vetModels.add(vetModel);
		}
		return vetModels;
	}

	public VetModel getVet(long id) {
		VetEntity vet = vetRepository.findById(id).orElseGet(VetEntity::new);
		VetModel vetModel = new VetModel();
		BeanUtils.copyProperties(vet, vetModel);
		return vetModel;
	}

	public void addUpdateVet(VetModel vetModel) {
		VetEntity vet = new VetEntity();
		BeanUtils.copyProperties(vetModel, vet);
		vetRepository.save(vet);
	}

	public void deleteVet(long id) {
		vetRepository.deleteById(id);
	}
}
