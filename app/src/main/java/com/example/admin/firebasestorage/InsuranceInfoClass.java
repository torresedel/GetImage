package com.example.admin.firebasestorage;

/**
 * Created by Admin on 10/19/2017.
 */

public class InsuranceInfoClass {
    private String type;
    private String companyName;
    private String packageName;
    private String packageDetailsUrl;

    public InsuranceInfoClass(String type, String companyName, String packageName, String packageDetailsUrl) {
        this.type = type;
        this.companyName = companyName;
        this.packageName = packageName;
        this.packageDetailsUrl = packageDetailsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDetailsUrl() {
        return packageDetailsUrl;
    }

    public void setPackageDetailsUrl(String packageDetailsUrl) {
        this.packageDetailsUrl = packageDetailsUrl;
    }
}
