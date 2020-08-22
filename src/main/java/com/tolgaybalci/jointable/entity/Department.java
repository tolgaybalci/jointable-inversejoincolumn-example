package com.tolgaybalci.jointable.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column
    private String departmentName;

    @Column
    private String adress;

    @OneToMany(mappedBy = "department")
    private List<Personel> personels;

}
