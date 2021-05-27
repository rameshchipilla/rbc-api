package git.rbc.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import git.rbc.api.entity.PetEntity;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {
}