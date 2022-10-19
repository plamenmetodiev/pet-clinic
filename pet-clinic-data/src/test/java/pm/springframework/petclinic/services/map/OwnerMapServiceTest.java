package pm.springframework.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pm.springframework.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
//        ownerMapService.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void delete() {
    }

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByLastName() {
    }
}