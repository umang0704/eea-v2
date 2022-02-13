package com.eea.v2.model.pe.signup;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@Data
public class AddLeaderReq {
    private String peId;
    private String name;
    private String aboutLife;
    private String significantWork;
    private String from;
    private String to;
    private String isPresentLeader;
    private String born;
    private String death;
    private String isAlive;
    private MultipartFile image;
}
