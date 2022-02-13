package com.eea.v2.service.pe.db;

import com.eea.v2.model.pe.db.Manifesto;
import com.eea.v2.repo.pe.db.ManifestoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManifestoService {
    @Autowired
    private ManifestoRepo manifestoRepo;

    public Manifesto add(Manifesto manifesto){
        return this.manifestoRepo.save(manifesto);
    }
}
