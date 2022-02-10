package com.eea.v2.controller.pe;

import com.eea.v2.model.pe.PE;
import com.eea.v2.service.pe.PELogoService;
import com.eea.v2.service.pe.PEService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/pe")
public class PEController {
    @Autowired
    private PEService peService;

    @Autowired
    private PELogoService logoService;


    /**
     * initiate PE account
     * {
     *     "name":"-",
     *     "email":"-",
     *     "password:"-"
     * }
     * Output
     * {
     *      "id":"-",
     *      "name":"-",
     * }
     * @param pe
     * @return
     */
    @PostMapping(path = "/initiateAccount")
    public JSONObject initiateAccount(@RequestBody JSONObject pe){
        PE pe1 =new PE();
        pe1.setName(pe.get("name").toString());
        pe1.setEmail(pe.get("email").toString());
        pe1.setPassword(pe.get("password").toString());
        return this.peService.initiateAccount(pe1);
    }

    /**
     * Save Basic Details - saveBasicDetails
     * Input
     * {
     *     "id":"-",
     *     "about":"-",
     *     "website-link":"-",
     *     "from":"-"
     * }
     * Output
     * {
     *     "id":"-",
     *     "name":"-",
     * }
     * @param entity
     * @return
     */
    @PostMapping(path = "/saveBasicDetails")
    public JSONObject saveBasicDetails(@RequestBody JSONObject entity){
        JSONObject ret = new JSONObject();
        PE pe = this.peService.findById(Integer.parseInt(entity.get("id").toString())).get();
        if(pe!=null){
            PE temp = this.peService.saveBasicDetails(pe,entity);
            ret.put("id",temp.getId());
            ret.put("name",temp.getName());
        }else{
            ret.put("error","Account with id not found");
        }
        return ret;
    }


    @GetMapping("/all")
    public List<PE> getAll(){
       return this.peService.getAll();
    }
}
