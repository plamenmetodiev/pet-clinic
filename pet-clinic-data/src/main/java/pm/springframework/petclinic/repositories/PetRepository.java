package pm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pm.springframework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
