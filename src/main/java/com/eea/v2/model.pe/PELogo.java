package com.eea.v2.model.pe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "pe_logo")
@Getter
@Setter
@NoArgsConstructor
public class PELogo {
    @Id
    @SequenceGenerator(name = "pe_logo_sequence",sequenceName = "pe_logo_sequence",allocationSize = 1)
    @GeneratedValue(generator = "pe_logo_sequence",strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer peId;
    private String filename;
    private String filetype;
    @Lob
    private byte[] fileData;

}
