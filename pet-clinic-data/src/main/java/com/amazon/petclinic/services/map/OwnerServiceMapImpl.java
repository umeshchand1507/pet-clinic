package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Owner;
import com.amazon.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Long, Owner> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        Owner matchedOwner = null;
        for (Owner owner : map.values()) {
            if (lastName.equals(owner.getLastName())) {
                matchedOwner = owner;
                break;
            }
        }
        return matchedOwner;
    }
}
