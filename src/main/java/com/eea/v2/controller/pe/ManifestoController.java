package com.eea.v2.controller.pe;

import com.eea.v2.model.pe.db.Manifesto;
import com.eea.v2.model.pe.signup.AddManifestoReq;
import com.eea.v2.model.pe.signup.AddManifestoResp;
import com.eea.v2.service.pe.db.ManifestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/manifesto")
public class ManifestoController {
    @Autowired
    private ManifestoService manifestoService;

    @PostMapping(path = "/add")
    public AddManifestoResp add(AddManifestoReq model){
        try {
            MultipartFile file = model.getFile();
            Manifesto m = Manifesto.builder()
                    .peId(model.getPeId())
                    .fileName(file.getOriginalFilename())
                    .fileContentType(file.getContentType())
                    .fileData(file.getBytes())
                    .build();
            m = this.manifestoService.add(m);
            return AddManifestoResp.builder()
                    .fileName(m.getFileName())
                    .fileSize(Double.toString((file.getSize()*0.00000095367432)))
                    .fileType(file.getContentType())
                    .build();
        }catch (RuntimeException e){
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AddManifestoResp.builder().build();
    }
}
