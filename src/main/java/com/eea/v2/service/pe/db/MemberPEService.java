package com.eea.v2.service.pe.db;

import com.eea.v2.model.pe.db.MemberPE;
import com.eea.v2.repo.pe.db.MemberPERepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class MemberPEService {
    @Autowired
    private MemberPERepo repo;

    @Transactional(rollbackFor = SQLException.class)
    public boolean save(MemberPE memberPE){
        this.repo.save(memberPE);
        return true;
    }
}
