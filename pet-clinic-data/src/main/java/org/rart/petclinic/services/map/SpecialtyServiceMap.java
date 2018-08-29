package org.rart.petclinic.services.map;

import org.rart.petclinic.models.Specialty;
import org.rart.petclinic.services.SpecialtiesService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty,Long> implements SpecialtiesService {

    @Override
    public Specialty findById(Long id) {
        return  super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }
}
