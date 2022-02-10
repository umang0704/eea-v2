package com.eea.v2.service.pe;

import com.eea.v2.model.pe.PE;
import com.eea.v2.repo.pe.PERepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PEService {
    @Autowired
    private PERepo repo;



    public JSONObject initiateAccount(PE entity){
          this.repo.save(entity);
          JSONObject object = new JSONObject();
          object.put("id",entity.getId());
          object.put("name",entity.getName());
          return object;
    }

    public PE saveBasicDetails(PE pe,JSONObject object){
        pe.setAbout(object.get("about").toString());
        pe.setWebsite(object.get("website").toString());
        try {
            java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(object.get("from").toString());
            pe.setDate(new Date(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this.repo.save(pe);
    }
    public PE saveBasicDetails01(PE pe,JSONObject object){
        pe.setAbout(object.get("about").toString());
        pe.setWebsite(object.get("website").toString());
        try {
            java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(object.get("from").toString());
            pe.setDate(new Date(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this.repo.save(pe);
    }


    //Basic Operations
    public List<PE> getAll(){
        return this.repo.findAll();
    }
    public Optional<PE> findById(Integer id){
        return this.repo.findById(id);
    }

}
