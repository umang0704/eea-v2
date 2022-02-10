package com.eea.v2.service.pe;

import com.eea.v2.model.pe.PELogo;
import com.eea.v2.repo.pe.PELogoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PELogoService {
    @Autowired
    private PELogoRepo repo;

    public PELogo uploadLogo(Integer peId,MultipartFile logo){
        try{
            PELogo file = new PELogo();
            file.setPeId(peId);
            file.setFileData(logo.getBytes());
            file.setFilename(logo.getName());
            file.setFiletype(logo.getContentType());
            System.out.println(logo.getSize()* 0.00000095367432);;
            return this.repo.save(file);
        }
        catch (RuntimeException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
