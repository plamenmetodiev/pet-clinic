package pm.springframework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pm.springframework.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
