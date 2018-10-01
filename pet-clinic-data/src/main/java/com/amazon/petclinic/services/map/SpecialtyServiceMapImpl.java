package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Specialty;
import com.amazon.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceMapImpl extends AbstractMapService<Long, Specialty> implements SpecialtyService {
}
