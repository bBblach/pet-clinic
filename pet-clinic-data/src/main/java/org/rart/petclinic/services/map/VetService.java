package org.rart.petclinic.services.map;

import org.rart.petclinic.models.Vet;
import org.rart.petclinic.services.CrudService;

import java.util.Set;

public class VetService extends AbstractMapService<Vet,Long> implements CrudService<Vet,Long> {


    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
}