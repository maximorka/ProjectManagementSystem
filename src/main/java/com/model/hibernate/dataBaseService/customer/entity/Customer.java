package com.model.hibernate.dataBaseService.customer.entity;

import com.model.hibernate.dataBaseService.project.entity.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String address;


    @OneToMany(targetEntity=Project.class, mappedBy="customer", fetch=FetchType.LAZY)
    private List<Project> projects;
}
