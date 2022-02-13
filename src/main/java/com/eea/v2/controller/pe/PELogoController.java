package com.eea.v2.controller.pe;

import com.eea.v2.model.pe.db.PELogo;
import com.eea.v2.service.pe.db.PELogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/peLogo")
public class PELogoController {
    @Autowired
    private PELogoService service;

    @PostMapping("/upload/{id}")
    private ResponseEntity<ByteArrayResource> uploadFile(@PathVariable(name="id") Integer peId, @RequestParam("logo") MultipartFile file) throws IOException {
        PELogo uploaded = service.uploadLogo(peId,file);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"filename:name="+uploaded.getFilename())
                .contentType(MediaType.parseMediaType(uploaded.getFiletype()))
                .body(new ByteArrayResource(uploaded.getFileData()));
    }
}
