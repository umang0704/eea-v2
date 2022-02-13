package com.eea.v2.model.pe.signup;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
public class AddManifestoReq {
    private Integer peId;
    private MultipartFile file;
}
