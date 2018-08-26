package org.rart.petclinic.services;

import org.rart.petclinic.models.Owner;

public interface OwnerService  extends  CrudService<Owner,Long> {
     Owner findByLastName(String lastName);
}
