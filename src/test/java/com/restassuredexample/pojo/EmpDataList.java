package com.restassuredexample.pojo;

import java.util.List;

public class EmpDataList {

    private Integer page;
    private Integer perPage;
    private Integer total;
    private Integer totalPages;
    private List<EmpPersonalData> data = null;
    private EmpProfessionalData ad;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<EmpPersonalData> getData() {
        return data;
    }

    public void setData(List<EmpPersonalData> data) {
        this.data = data;
    }

    public EmpProfessionalData getAd() {
        return ad;
    }

    public void setAd(EmpProfessionalData ad) {
        this.ad = ad;
    }

}