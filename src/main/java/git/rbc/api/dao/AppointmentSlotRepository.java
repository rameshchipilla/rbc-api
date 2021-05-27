package git.rbc.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import git.rbc.api.entity.AppointmentSlotEntity;

@Repository
public interface AppointmentSlotRepository extends CrudRepository<AppointmentSlotEntity, Long> {

}