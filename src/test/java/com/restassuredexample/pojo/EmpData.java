package com.restassuredexample.pojo;

public class EmpData {
    EmpPersonalData data;
    EmpProfessionalData ad;


    // Getter Methods

    public EmpPersonalData getEmpPersonalData() {
        return data;
    }

    public EmpProfessionalData getEmpProfessionalData() {
        return ad;
    }

    // Setter Methods

    public void setEmpPersonalData(EmpPersonalData data) {
        this.data = data;
    }

    public void setEmpProfessionalData(EmpProfessionalData ad) {
        this.ad = ad;
    }

}

