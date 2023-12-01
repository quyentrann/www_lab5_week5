package vn.edu.iuh.fit.models;

public class ResponseLogin {
    private boolean isCompany;
    private boolean isCandidate;
    private Object data;

    public ResponseLogin(boolean isCompany, boolean isCandidate, Object data) {
        this.isCompany = isCompany;
        this.isCandidate = isCandidate;
        this.data = data;
    }

    public ResponseLogin() {
    }

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public boolean isCandidate() {
        return isCandidate;
    }

    public void setCandidate(boolean candidate) {
        isCandidate = candidate;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
