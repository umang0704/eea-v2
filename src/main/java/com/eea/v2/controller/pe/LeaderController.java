package com.eea.v2.controller.pe;

import com.eea.v2.model.general.Image;
import com.eea.v2.model.pe.db.Leader;
import com.eea.v2.model.pe.signup.AddLeaderReq;
import com.eea.v2.model.pe.signup.AddLeaderResp;
import com.eea.v2.service.general.ImageService;
import com.eea.v2.service.general.SQLDateService;
import com.eea.v2.service.pe.db.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/leader")
public class LeaderController {
    @Autowired
    private LeaderService leaderService;
    @Autowired
    private ImageService imageService;

    @PostMapping(path = "/add")
    public AddLeaderResp add(@RequestBody AddLeaderReq req){
        try{
            MultipartFile file = req.getImage();
            Image i = new Image(file.getName(), file.getContentType(), file.getBytes());
            i =this.imageService.saveImage(i);
            Leader leader = Leader.builder()
                    .peId(Integer.parseInt(req.getPeId()))
                    .name(req.getName())
                    .aboutLife(req.getAboutLife())
                    .significantWork(req.getSignificantWork())
                    .born(SQLDateService.getSQLDate("dd-MM-yyyy", req.getBorn()))
                    .death(SQLDateService.getSQLDate("dd-MM-yyyy",req.getDeath()))
                    .isAlive(req.getIsAlive())
                    .fromYear(SQLDateService.getSQLDate("dd-MM-yyyy",req.getFrom()))
                    .toYear(SQLDateService.getSQLDate("dd-MM-yyyy",req.getTo()))
                    .isPresentLeader(req.getIsPresentLeader())
                    .imageId(i.getId())
                    .build();
            leader = this.leaderService.save(leader);
            return AddLeaderResp.builder()
                    .name(leader.getName())
                    .build();
        }catch(RuntimeException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return AddLeaderResp.builder().build();
    }
}
