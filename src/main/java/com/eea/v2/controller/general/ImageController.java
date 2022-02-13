package com.eea.v2.controller.general;

import com.eea.v2.model.general.Image;
import com.eea.v2.service.general.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping(path = "/byId/{id}")
    public ResponseEntity<ByteArrayResource> getImageById(@PathVariable(name = "id") Integer id){
        Image image = this.imageService.getImage(id).get();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"filename="+image.getName())
                .body(new ByteArrayResource(image.getData()));
    }
}
