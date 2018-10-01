package com.amazon.petclinic.bootstrap;

import com.amazon.petclinic.model.*;
import com.amazon.petclinic.services.OwnerService;
import com.amazon.petclinic.services.PetTypeService;
import com.amazon.petclinic.services.SpecialtyService;
import com.amazon.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType  = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType  = petTypeService.save(cat);

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
        owner1.setId(1L);
        owner1.setFirstName("umesh");
        owner1.setLastName("chand");
        owner1.setAddress("H604 Akme Ballet");
        owner1.setCity("Bengaluru");
        owner1.setTelephone("9891346509");

        Pet umeshsPet = new Pet();
        umeshsPet.setPetType(savedDogPetType);
        umeshsPet.setBirthDate(LocalDate.now());
        umeshsPet.setOwner(owner1);
        umeshsPet.setName("Rocky");
        owner1.getPets().add(umeshsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("priyanka");
        owner2.setLastName("singh");
        owner2.setAddress("H604 Akme Ballet");
        owner2.setCity("Bengaluru");
        owner2.setTelephone("9891346509");

        Pet priyankasPet = new Pet();
        priyankasPet.setPetType(savedCatPetType);
        priyankasPet.setBirthDate(LocalDate.now());
        priyankasPet.setOwner(owner2);
        priyankasPet.setName("Pussy");
        owner2.getPets().add(priyankasPet);

        ownerService.save(owner2);
        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("ravi");
        vet1.setLastName("gupta");
        vet1.getSpecialties().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("nitesh");
        vet2.setLastName("srivastava");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedRadiology);
        vetService.save(vet2);
        System.out.println("Vets loaded...");

    }
}
