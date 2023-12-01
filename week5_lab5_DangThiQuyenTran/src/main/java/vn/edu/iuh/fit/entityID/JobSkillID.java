package vn.edu.iuh.fit.entityID;

import java.io.Serializable;

public class JobSkillID implements Serializable {
    private long job;
    private long skill;

    public JobSkillID(long job, long skill) {
        this.job = job;
        this.skill = skill;
    }

    public JobSkillID() {
    }

    public long getJob() {
        return job;
    }

    public void setJob(long job) {
        this.job = job;
    }

    public long getSkill() {
        return skill;
    }

    public void setSkill(long skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "JobSkillID{" +
                "job=" + job +
                ", skill=" + skill +
                '}';
    }
}
