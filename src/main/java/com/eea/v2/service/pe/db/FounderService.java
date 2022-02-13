package com.eea.v2.service.pe.db;

import com.eea.v2.model.pe.db.Founder;
import com.eea.v2.repo.pe.db.FounderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FounderService {
    @Autowired
    private FounderRepo repo;

    public Founder addFounder(Founder founder){
        return this.repo.save(founder);
    }

    public List<Founder> findByPEId(Integer peId){
        return this.repo.findByPeId(peId);
    }
}
