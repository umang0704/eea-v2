package com.eea.v2.model.pe.signup;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class AddManifestoResp {
    private String fileSize;
    private String fileType;
    private String fileName;
}
