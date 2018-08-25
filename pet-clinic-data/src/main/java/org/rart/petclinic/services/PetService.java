package org.rart.petclinic.services;

import org.rart.petclinic.model.Owner;
import org.rart.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Owner owner);
    Set<Pet> findAll();
}
