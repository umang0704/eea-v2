package com.eea.v2.controller.pe;

import com.eea.v2.service.general.PEMemberFileDataFormatChecker;
import com.eea.v2.service.pe.db.MemberPEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/peMembers")
public class MemberPEController {
    @Autowired
    private MemberPEService memberPEService;

    @PostMapping(path = "/file")
    public ResponseEntity<String> saveMembers(MultipartFile file){
        String status = "OK";
        HashMap<String,Integer> result = PEMemberFileDataFormatChecker.checkFileFormat(file);
        return  ResponseEntity.ok(result.toString());
    }
}
