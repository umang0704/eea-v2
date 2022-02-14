package com.eea.v2.controller.general;

import com.eea.v2.ApplicationResource;
import com.eea.v2.model.general.SampleFiles;
import com.eea.v2.model.pe.signup.AddSampleFileReq;
import com.eea.v2.model.pe.signup.AddSampleFileResp;
import com.eea.v2.service.general.FileSizeImp;
import com.eea.v2.service.general.SampleFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/sample_file")
public class SampleFileController {
    @Autowired
    private SampleFilesService sampleFilesService;

    @GetMapping(path = "/download_pe_member_file")
    public ResponseEntity<ByteArrayResource> downloadAllMemberPEFileFormat(){
        SampleFiles file = this.sampleFilesService.download(ApplicationResource.SAMPLE_FILE_FOR_ALL_PE_MEMBER).get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"filename:"+file.getFileFor())
                .contentType(MediaType.parseMediaType(file.getFileContentType()))
                .body(new ByteArrayResource(file.getData()));
    }

    @PostMapping(path = "/save_pe_member_file")
    public AddSampleFileResp saveSampleFileForAllMemberPE(AddSampleFileReq model){
        try {
            MultipartFile multipartFile = model.getFile();
            SampleFiles files =SampleFiles.builder()
                    .fileFor(ApplicationResource.SAMPLE_FILE_FOR_ALL_PE_MEMBER)
                    .fileName(multipartFile.getName())
                    .data(multipartFile.getBytes())
                    .fileContentType(multipartFile.getContentType())
                    .build();
            files = this.sampleFilesService.save(files);
            return AddSampleFileResp.builder()
                    .sampleFileFor(files.getFileFor())
                    .fileContentType(files.getFileContentType())
                    .fileSize(FileSizeImp.getSizeInMB(multipartFile.getSize()).toString())
                    .fileName(files.getFileName())
                    .build();
        }catch (IOException e_io){
            e_io.printStackTrace();
        }
    return AddSampleFileResp.builder().build();
    }
}