package com.amazon.petclinic.services;

import com.amazon.petclinic.model.Owner;

public interface OwnerService extends CrudService<Long, Owner> {

    Owner findByLastName(String lastName);

}
