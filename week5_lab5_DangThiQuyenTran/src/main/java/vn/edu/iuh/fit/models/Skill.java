package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {
    @Id
    @Column(name = "skill_id")
    private long id;
    @Column(name = "skill_type")
    private SkillType skillType;
    @Column(name = "skill_name")
    private String skillName;
    @Column(name = "skill_desc")
    private String skillDescription;
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobSkill> jobSkills;

    public Skill(long id, SkillType skillType, String skillName, String skillDescription) {
        this.id = id;
        this.skillType = skillType;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
    }

    public Skill() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public List<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(List<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }



}
