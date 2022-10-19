package pm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pm.springframework.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
