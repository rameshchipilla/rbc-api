package git.rbc.api.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import git.rbc.api.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

	List<AppointmentEntity> findByPetId(long petId);

	List<AppointmentEntity> findByVetId(long vetId);

	List<AppointmentEntity> findByVetIdAndAppointmentDate(long vetId,
			@DateTimeFormat(pattern = "YYYY-MM-DD") Date appointmentDate);

}