package com.eea.v2.service.general;

import com.eea.v2.model.general.Image;
import com.eea.v2.repo.general.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepo imageRepo;

    public Image saveImage(Image image){
       return  this.imageRepo.save(image);
    }

    public Optional<Image> getImage(Integer id){
        return this.imageRepo.findById(id);
    }
}
