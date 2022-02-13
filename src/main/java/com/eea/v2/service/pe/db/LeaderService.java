package com.eea.v2.service.pe.db;

import com.eea.v2.model.pe.db.Leader;
import com.eea.v2.repo.pe.db.LeaderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderService {
    @Autowired
    private LeaderRepo leaderRepo;

    public Leader save(Leader leader){
        return this.leaderRepo.save(leader);
    }
}
