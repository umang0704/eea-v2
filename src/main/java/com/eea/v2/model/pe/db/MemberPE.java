package com.eea.v2.model.pe.db;

import lombok.*;

import javax.persistence.*;

@Table(name = "member_pe")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MemberPE {
    @Id
    @SequenceGenerator(name = "memberPe_seq", sequenceName = "memberPe_seq",allocationSize = 1)
    @GeneratedValue(generator = "memberPe_seq",strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String contact;
    private String address;
    private String city;
    private String state;
}
