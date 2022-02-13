package com.eea.v2.model.pe.signup;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InitiateAccountResp {
    private String id;
    private String name;
}
