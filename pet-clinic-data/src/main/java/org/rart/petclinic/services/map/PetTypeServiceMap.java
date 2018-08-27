package org.rart.petclinic.services.map;

import org.rart.petclinic.models.PetType;
import org.rart.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends  AbstractMapService<PetType,Long> implements PetTypeService {


   /* GURU
   @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }
    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }
    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }*/
    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
}
