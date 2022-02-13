package com.eea.v2.model.general;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name = "image")
@Getter
@Setter
@Embeddable
public class Image {
    @Id
    @SequenceGenerator(name = "image_seq",sequenceName = "image_seq",allocationSize = 1)
    @GeneratedValue(generator = "image_seq",strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date date;
    private String name;
    private String contentType;
    @Lob
    private byte[] data;

    public Image() {
    }

    public Image(String name, String contentType, byte[] data) {
        this.name = name;
        this.contentType = contentType;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
