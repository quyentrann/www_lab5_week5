package vn.edu.iuh.fit.models;

import java.util.List;

public class ResponseCompany {
    private int totalPages;
    private List<Company> companies;

    public ResponseCompany(int totalPages, List<Company> companies) {
        this.totalPages = totalPages;
        this.companies = companies;
    }

    public ResponseCompany() {
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
