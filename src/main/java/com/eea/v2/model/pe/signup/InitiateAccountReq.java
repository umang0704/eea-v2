package com.eea.v2.model.pe.signup;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InitiateAccountReq {
    private String name;
    private String email;
    private String password;
}
