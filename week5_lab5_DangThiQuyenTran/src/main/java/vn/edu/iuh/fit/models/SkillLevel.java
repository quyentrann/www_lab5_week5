package vn.edu.iuh.fit.models;

public enum SkillLevel {
    BEGINER(0),
    INTERMEDIATE(1),
    ADVANCED(2),
    PROFESSIONAL(3),
    MASTER(4);

    private int level;

    SkillLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
