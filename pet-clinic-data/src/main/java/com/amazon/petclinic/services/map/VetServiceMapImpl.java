package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Specialty;
import com.amazon.petclinic.model.Vet;
import com.amazon.petclinic.services.SpecialtyService;
import com.amazon.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMapImpl extends AbstractMapService<Long, Vet> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMapImpl(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialties().size() > 0 ) {
            object.getSpecialties().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }
}
