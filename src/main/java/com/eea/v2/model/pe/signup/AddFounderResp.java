package com.eea.v2.model.pe.signup;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class AddFounderResp {
    private String name;
}
