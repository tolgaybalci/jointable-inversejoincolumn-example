package com.tolgaybalci.jointable.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personelId;

    @Column
    private String isim;

    @Column
    private String soyisim;

    @Column
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dogumTarihi;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="Personel_Department",
            joinColumns=@JoinColumn(name="Personel_Id"),
            inverseJoinColumns=@JoinColumn(name="Department_Id")
    )
    private Department department;
}
