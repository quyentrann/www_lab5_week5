package vn.edu.iuh.fit.entityID;

import java.io.Serializable;

public class CandidateSkillID implements Serializable {
    private long candidate;
    private long skill;

    public CandidateSkillID(long candidate, long skill) {
        this.candidate = candidate;
        this.skill = skill;
    }

    public CandidateSkillID() {
    }

    public long getCandidate() {
        return candidate;
    }

    public void setCandidate(long candidate) {
        this.candidate = candidate;
    }

    public long getSkill() {
        return skill;
    }

    public void setSkill(long skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "CandidateSkillID{" +
                "candidate=" + candidate +
                ", skill=" + skill +
                '}';
    }
}
