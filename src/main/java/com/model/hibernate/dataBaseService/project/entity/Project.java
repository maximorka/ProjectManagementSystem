package com.model.hibernate.dataBaseService.project.entity;

import com.model.hibernate.dataBaseService.company.entity.Company;
import com.model.hibernate.dataBaseService.customer.entity.Customer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
public class Project {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ToString.Exclude
    @ManyToOne
    private Company company;

    @ToString.Exclude
    @ManyToOne
    private Customer customer;


    @Column(name = "cost")
    private int cost;
    @Column(name = "date")
    private Date date;
}
