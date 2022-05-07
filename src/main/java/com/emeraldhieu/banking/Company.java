package com.emeraldhieu.banking;

public class Company extends AccountHolder {
    private final String companyName;
    private final int taxId;

    public Company(String companyName, int taxId) {
        super(taxId); // NOT SURE!
        this.companyName = companyName;
        this.taxId = taxId;
    }

    public String getCompanyName() {
        return companyName;
    }
}
