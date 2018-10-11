package com.amazon.petclinic.services.springdatajpa;

import com.amazon.petclinic.model.Specialty;
import com.amazon.petclinic.repositories.SpecialtyRepository;
import com.amazon.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtyServiceSDJImpl implements SpecialtyService {
    private SpecialtyRepository specialtyRepository;

    public SpecialtyServiceSDJImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        Optional<Specialty> specialtyOptional = specialtyRepository.findById(aLong);
        return specialtyOptional.orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
