package com.amazon.petclinic.bootstrap;

import com.amazon.petclinic.model.Owner;
import com.amazon.petclinic.model.Vet;
import com.amazon.petclinic.services.OwnerService;
import com.amazon.petclinic.services.VetService;
import com.amazon.petclinic.services.map.OwnerServiceMapImpl;
import com.amazon.petclinic.services.map.VetServiceMapImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMapImpl();
        vetService = new VetServiceMapImpl();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("umesh");
        owner1.setLastName("chand");

        ownerService.save(owner1.getId(), owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("priyanka");
        owner2.setLastName("singh");
        ownerService.save(owner2.getId(), owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("ravi");
        vet1.setLastName("gupta");
        vetService.save(vet1.getId(), vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("nitesh");
        vet1.setLastName("srivastava");
        vetService.save(vet2.getId(), vet2);

    }
}
