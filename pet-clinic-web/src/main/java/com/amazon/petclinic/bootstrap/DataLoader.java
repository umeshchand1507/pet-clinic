package com.amazon.petclinic.bootstrap;

import com.amazon.petclinic.model.Owner;
import com.amazon.petclinic.model.Vet;
import com.amazon.petclinic.services.OwnerService;
import com.amazon.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("umesh");
        owner1.setLastName("chand");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("priyanka");
        owner2.setLastName("singh");
        ownerService.save(owner2);
        System.out.println("Owners loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("ravi");
        vet1.setLastName("gupta");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("nitesh");
        vet2.setLastName("srivastava");
        vetService.save(vet2);
        System.out.println("Vets loaded...");

    }
}
