package fr.m2i.service.serviceImpl;

import fr.m2i.business.Company;
import fr.m2i.service.CompanyService;
import fr.m2i.business.Company;
import fr.m2i.service.CompanyService;

import java.util.ArrayList;

public class CompanyServiceImpl implements CompanyService {
    private static ArrayList<Company> companies = new ArrayList<Company>() ;

    @Override
    public Company getCompany(Long id) {
        for (Company company :
                companies) {
            if (company.getId().equals(id)) {
                return company;
            }
        }
        return null;
    }

    @Override
    public Company addCompany(String name) {
        Company newCompany = new Company(name);
        companies.add(newCompany);
        return newCompany;
    }

    @Override
    public ArrayList<Company> getCompanies() {
        return companies;
    }
}
