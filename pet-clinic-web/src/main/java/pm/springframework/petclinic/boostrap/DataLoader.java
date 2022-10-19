package pm.springframework.petclinic.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pm.springframework.petclinic.model.*;
import pm.springframework.petclinic.services.OwnerService;
import pm.springframework.petclinic.services.PetTypeService;
import pm.springframework.petclinic.services.SpecialtyService;
import pm.springframework.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
     }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();

        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Ivanov");
        owner1.setAddress("23 ave Street");
        owner1.setCity("Sofia");
        owner1.setTelephone("1252526");

        Pet johnPet = new Pet();
        johnPet.setPetType(savedCatPetType);
        johnPet.setOwner(owner1);
        johnPet.setBirthDate(LocalDate.now());
        johnPet.setName("Mike");

        owner1.getPets().add(johnPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Izabel");
        owner2.setLastName("Treskova");
        owner2.setAddress("25 ave Street");
        owner2.setCity("Plovdiv");
        owner2.setTelephone("125253226");

        Pet izabelPet = new Pet();
        izabelPet.setPetType(savedDogPetType);
        izabelPet.setOwner(owner2);
        izabelPet.setBirthDate(LocalDate.now());
        izabelPet.setName("Lucky");

        owner2.getPets().add(izabelPet);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Dow");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mat");
        vet2.setLastName("Tray");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);
    }
}
