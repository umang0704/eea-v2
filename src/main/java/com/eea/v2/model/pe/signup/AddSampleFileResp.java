package com.eea.v2.model.pe.signup;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class AddSampleFileResp {
    private String fileName;
    private String fileSize;
    private String sampleFileFor;
    private String fileContentType;
}
