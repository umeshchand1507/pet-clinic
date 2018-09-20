package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Vet;
import com.amazon.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMapImpl extends AbstractMapService<Long, Vet> implements VetService {
}
