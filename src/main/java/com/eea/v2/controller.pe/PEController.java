package com.eea.v2.controller.pe;

import com.eea.v2.model.pe.PE;
import com.eea.v2.service.pe.PEService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pe")
public class PEController {
    @Autowired
    private PEService peService;

    @PostMapping(path = "/save")
    public PE savePE(@RequestBody JSONObject pe){
        PE pe1 =new PE();
        pe1.setName(pe.get("name").toString());
        pe1.setEmail(pe.get("email").toString());
        pe1.setPassword(pe.get("password").toString());
        return this.peService.savePE(pe1);
    }

    @GetMapping("/all")
    public List<PE> getAll(){
       return this.peService.getAll();
    }
}
