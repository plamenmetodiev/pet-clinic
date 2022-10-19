package pm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pm.springframework.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
