package com.eea.v2.model.pe.signup;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveBasicDetailsReq {
    private String id;
    private String about;
    private String website;
    private String from;
}
