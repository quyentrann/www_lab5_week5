package vn.edu.iuh.fit.entity;

import vn.edu.iuh.fit.models.Address;

import java.util.List;

public class ResponsePages {
    private int totalPages;
    private Object datas;

    public ResponsePages(int totalPages, Object datas) {
        this.totalPages = totalPages;
        this.datas = datas;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }
}
