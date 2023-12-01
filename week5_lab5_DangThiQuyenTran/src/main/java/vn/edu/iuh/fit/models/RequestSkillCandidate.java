package vn.edu.iuh.fit.models;

public class RequestSkillCandidate {
    private long candidateID;
    private long companyID;

    public RequestSkillCandidate() {
    }

    public RequestSkillCandidate(long candidateID, long companyID) {
        this.candidateID = candidateID;
        this.companyID = companyID;
    }

    public long getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(long candidateID) {
        this.candidateID = candidateID;
    }

    public long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(long companyID) {
        this.companyID = companyID;
    }
}
