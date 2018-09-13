package com.amazon.petclinic.services;

import com.amazon.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet pet);

    Set<Vet> findAll();
}
