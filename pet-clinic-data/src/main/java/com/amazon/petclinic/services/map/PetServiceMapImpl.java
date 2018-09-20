package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Pet;
import com.amazon.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMapImpl extends AbstractMapService<Long, Pet> implements PetService {
}
