package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.PetType;
import com.amazon.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeServiceMapImpl extends AbstractMapService<Long, PetType> implements PetTypeService {

}
