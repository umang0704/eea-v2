package com.eea.v2.service.pe.db;

import com.eea.v2.model.pe.db.PE;
import com.eea.v2.model.pe.signup.SaveBasicDetailsReq;
import com.eea.v2.repo.pe.db.PERepo;
import com.eea.v2.service.general.SQLDateService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PEService {
    @Autowired
    private PERepo repo;


    public PE initiateAccount(PE entity) {
        return this.repo.save(entity);
    }


    public PE saveBasicDetails(PE pe, SaveBasicDetailsReq model) {
        pe.setAbout(model.getAbout());
        pe.setDate(SQLDateService.getSQLDate("dd-MM-YYYY", model.getFrom()));
        pe.setWebsite(model.getWebsite());
        return this.repo.save(pe);
    }


    //Basic Operations
    public List<PE> getAll() {
        return this.repo.findAll();
    }

    public Optional<PE> findById(Integer id) {
        return this.repo.findById(id);
    }

}
