package com.amazon.petclinic.services.map;

import com.amazon.petclinic.model.Visit;
import com.amazon.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitServiceMapImpl extends AbstractMapService<Long, Visit> implements VisitService {
    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit.");
        }
        return super.save(visit);
    }
}
