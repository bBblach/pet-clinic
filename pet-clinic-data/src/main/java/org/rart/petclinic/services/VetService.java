package org.rart.petclinic.services;

import org.rart.petclinic.model.Owner;
import org.rart.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByLastName(String lastName);
    Vet findById(Long id);
    Vet save(Owner owner);
    Set<Vet> findAll();
}

