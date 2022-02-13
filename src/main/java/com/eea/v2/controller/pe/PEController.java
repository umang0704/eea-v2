package com.eea.v2.controller.pe;

import com.eea.v2.model.pe.db.PE;
import com.eea.v2.model.pe.signup.InitiateAccountReq;
import com.eea.v2.model.pe.signup.InitiateAccountResp;
import com.eea.v2.model.pe.signup.SaveBasicDetailsReq;
import com.eea.v2.model.pe.signup.SaveBasicDetailsResp;
import com.eea.v2.service.pe.db.PELogoService;
import com.eea.v2.service.pe.db.PEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "/pe")
public class PEController {
    @Autowired
    private PEService peService;

    @Autowired
    private PELogoService logoService;


    @PostMapping(path = "/initiateAccount")
    public InitiateAccountResp initiateAccount(@RequestBody InitiateAccountReq model) {
        PE pe = PE.builder()
                .name(model.getName())
                .password(model.getPassword())
                .email(model.getEmail())
                .build();
        pe = this.peService.initiateAccount(pe);
        return InitiateAccountResp.builder()
                .id(pe.getId().toString())
                .name(pe.getName())
                .build();
    }


    @PostMapping(path = "/saveBasicDetails")
    public SaveBasicDetailsResp saveBasicDetails(@RequestBody SaveBasicDetailsReq entity){
        try {
            PE pe = this.peService.findById(Integer.parseInt(entity.getId())).get();
            if(pe!=null){
                pe = this.peService.saveBasicDetails(pe,entity);
                return  SaveBasicDetailsResp.builder()
                        .id(pe.getId().toString())
                        .name(pe.getName())
                        .build();
            }
        }catch (RuntimeException e){
            return SaveBasicDetailsResp.builder().build();
        }
        return SaveBasicDetailsResp.builder().build();
    }

    @GetMapping("/all")
    public List<PE> getAll() {
        return this.peService.getAll();
    }
}
