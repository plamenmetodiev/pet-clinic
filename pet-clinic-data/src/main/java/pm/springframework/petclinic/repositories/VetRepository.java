package pm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pm.springframework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
