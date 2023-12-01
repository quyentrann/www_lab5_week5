package vn.edu.iuh.fit.models;

public class ResponseInfo {
    private Job job;
    private Skill skill;
    private SkillLevel level;
    private String moreInfo;

    public ResponseInfo(Job job, Skill skill, SkillLevel level, String moreInfo) {
        this.job = job;
        this.skill = skill;
        this.level = level;
        this.moreInfo = moreInfo;
    }

    public ResponseInfo() {
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }
}
