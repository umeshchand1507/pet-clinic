package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Specialty;
import com.amazon.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyServiceMapImpl extends AbstractMapService<Long, Specialty> implements SpecialtyService {
}
