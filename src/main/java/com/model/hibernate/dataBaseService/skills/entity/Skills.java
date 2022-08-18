package com.model.hibernate.dataBaseService.skills.entity;

import com.model.hibernate.dataBaseService.skills.util.SkillsLevel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Skills {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column
    private String kategory;
    @Column
    @Enumerated(EnumType.STRING)
    private SkillsLevel level;
}
