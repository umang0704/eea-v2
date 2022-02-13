package com.eea.v2.controller.pe;

import com.eea.v2.model.general.Image;
import com.eea.v2.model.pe.db.Founder;
import com.eea.v2.model.pe.signup.AddFounderReq;
import com.eea.v2.model.pe.signup.AddFounderResp;
import com.eea.v2.service.general.ImageService;
import com.eea.v2.service.pe.db.FounderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "/founder")
public class FounderController {
    @Autowired
    private FounderService founderService;
    @Autowired
    private ImageService imageService;

    @PostMapping(path = "/add")
    public AddFounderResp addFounder(@ModelAttribute("founder") AddFounderReq founder) {
        try {
            MultipartFile file =founder.getFounderImage();
            Image i = this.imageService.saveImage(new Image(file.getName(),file.getContentType(),file.getBytes()));
            Founder f = new Founder(
                    Integer.parseInt(founder.getPeId()),
                    founder.getName(),
                    founder.getAboutLife(),
                    founder.getWork(),
                    founder.getBorn(),
                    founder.getDeath(),
                    i.getId()
            );
            f = this.founderService.addFounder(f);
            return AddFounderResp.builder().name(f.getName()).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AddFounderResp.builder().build();
    }
}
