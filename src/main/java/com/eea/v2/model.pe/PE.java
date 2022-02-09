package com.eea.v2.model.pe;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class PE {
    @Id
    @SequenceGenerator(name = "pe_sequence",sequenceName = "pe_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String email;
    private String password;

    private String about;
    private String website;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @Lob
    private byte[] logo;
}
