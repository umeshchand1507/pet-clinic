package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Owner;
import com.amazon.petclinic.model.Pet;
import com.amazon.petclinic.services.OwnerService;
import com.amazon.petclinic.services.PetService;
import com.amazon.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerServiceMapImpl extends AbstractMapService<Long, Owner> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerServiceMapImpl(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        Owner matchedOwner = null;
        for (Owner owner : map.values()) {
            if (lastName.equals(owner.getLastName())) {
                matchedOwner = owner;
                break;
            }
        }
        return matchedOwner;
    }

    @Override
    public Owner save(Owner object) {
        Owner savedOwner = null;
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("PetType must not be empty!!!...");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            savedOwner = super.save(object);
        }
        return savedOwner;
    }
}
