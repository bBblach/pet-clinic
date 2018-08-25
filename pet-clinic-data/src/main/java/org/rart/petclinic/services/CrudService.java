package org.rart.petclinic.services;

import org.springframework.data.repository.Repository;

import java.util.Set;

public interface CrudService <T,ID> extends  Repository <T,ID> {

    T findById(ID id);
    T save(T object);
    Set<T> findAll();
    void delete(T object);
    void deleteById(ID id);
}
