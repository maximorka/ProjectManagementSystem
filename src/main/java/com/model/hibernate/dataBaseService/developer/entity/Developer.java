package com.model.hibernate.dataBaseService.developer.entity;

import com.model.hibernate.dataBaseService.company.entity.Company;
import com.model.hibernate.dataBaseService.project.entity.Project;
import com.model.hibernate.dataBaseService.skills.entity.Skills;
import com.model.hibernate.dataBaseService.developer.util.SexEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Developer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @Column
    @Enumerated(EnumType.STRING)
    private SexEnum sex;

    @ToString.Exclude
    @ManyToOne
    private Company company;

    @Column
    private int salary;

    @ManyToMany
    @JoinTable(
            name = "developer_project",
            joinColumns = @JoinColumn(name = "develop_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    Set<Project> projects = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "developer_skills",
            joinColumns = @JoinColumn(name = "develop_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id")
    )
    Set<Skills> skills = new HashSet<>();
}
