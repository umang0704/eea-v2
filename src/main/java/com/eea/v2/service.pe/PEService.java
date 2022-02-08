package com.eea.v2.service.pe;

import com.eea.v2.model.pe.PE;
import com.eea.v2.repo.pe.PERepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PEService {
    @Autowired
    private PERepo repo;

    public PE savePE(PE entity){
        return  this.repo.save(entity);
    }
}
