package git.rbc.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import git.rbc.api.entity.VetEntity;

@Repository
public interface VetRepository extends CrudRepository<VetEntity, Long> {
}