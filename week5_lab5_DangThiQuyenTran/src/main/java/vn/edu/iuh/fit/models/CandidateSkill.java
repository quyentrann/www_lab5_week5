package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.Data;
import vn.edu.iuh.fit.entityID.CandidateSkillID;

import java.io.Serializable;

@Entity
@IdClass(CandidateSkillID.class)
@Table(name = "candidate_skill")
public class CandidateSkill implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Column(name = "skill_level")
    private SkillLevel skillLevel;
    @Column(name = "more_infos")
    private String moreInfo;

    public CandidateSkill(Candidate candidate, Skill skill, SkillLevel skillLevel, String moreInfo) {
        this.candidate = candidate;
        this.skill = skill;
        this.skillLevel = skillLevel;
        this.moreInfo = moreInfo;
    }

    public CandidateSkill() {

    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }



}
