package com.eea.v2.model.pe.signup;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
@Getter
@Setter
public class AddSampleFileReq {
    private MultipartFile file;
}
