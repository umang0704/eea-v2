package com.eea.v2.model.pe.signup;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class AddFounderReq {
    private String peId;
    private String name;
    private String aboutLife;
    private String work;
    private String born;
    private String death;
    private MultipartFile founderImage;
}
