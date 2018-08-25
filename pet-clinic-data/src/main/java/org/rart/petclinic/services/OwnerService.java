package org.rart.petclinic.services;

import org.rart.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{
    Owner findByLastName(String lastName);

}
