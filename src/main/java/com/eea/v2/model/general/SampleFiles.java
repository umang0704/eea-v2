package com.eea.v2.model.general;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sample_file")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SampleFiles {
    @Id
    @SequenceGenerator(name = "sample_file_seq",sequenceName = "sample_file_seq")
    @GeneratedValue(generator = "sample_file_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(unique = true)
    private String fileFor;
    private String fileName;
    private String fileContentType;
    @Lob
    private byte[] data;
}
