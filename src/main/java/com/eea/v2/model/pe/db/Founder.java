package com.eea.v2.model.pe.db;

import com.eea.v2.model.general.Image;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "founders")
@Getter
@Setter
@ToString
public class Founder {
    @Id
    @SequenceGenerator(name = "founder_seq",sequenceName = "founder_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "founder_seq")
    private Integer id;
    private Integer peId;
    private String name;
    private String aboutLife;
    private String work;
    private String born;
    private String death;
    private Integer imageId;

    public Founder() {
    }

    public Founder(Integer peId, String name, String aboutLife, String work, String born, String death, Integer imageId) {
        this.peId = peId;
        this.name = name;
        this.aboutLife = aboutLife;
        this.work = work;
        this.born = born;
        this.death = death;
        this.imageId = imageId;
    }
}
