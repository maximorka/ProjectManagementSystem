package com.model.feature.dataBaseService.skills.entity;

import com.model.feature.dataBaseService.skills.util.SkillsLevel;
import lombok.Data;

@Data
public class Skills {
private long id;
private String kategory;
private SkillsLevel level;
}
