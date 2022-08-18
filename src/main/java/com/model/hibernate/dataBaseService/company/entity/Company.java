package com.model.hibernate.dataBaseService.company.entity;


import com.model.hibernate.dataBaseService.developer.entity.Developer;
import com.model.hibernate.dataBaseService.project.entity.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(targetEntity = Developer.class, mappedBy = "company", fetch = FetchType.LAZY)
    private List<Developer> developers;


    @OneToMany(targetEntity = Project.class, mappedBy = "company", fetch = FetchType.LAZY)
    private List<Project> projects;


}
