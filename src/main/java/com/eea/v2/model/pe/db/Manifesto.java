package com.eea.v2.model.pe.db;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "manifesto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manifesto {
    @Id
    @SequenceGenerator(name = "manifesto_seq",sequenceName = "manifesto_seq", allocationSize = 1)
    @GeneratedValue(generator = "manifesto_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer peId;
    private String fileName;
    private String fileContentType;
    @Lob
    private byte[] fileData;
}
