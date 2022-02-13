package com.eea.v2.model.pe.db;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "leader")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Leader {
    @Id
    @SequenceGenerator(name = "leader_seq",sequenceName = "leader_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer peId;
    private String name;
    private String aboutLife;
    private String significantWork;
    private Date fromYear;
    private Date toYear;
    private String isPresentLeader;
    private Date born;
    private Date death;
    private String isAlive;
    private Integer imageId;
}
