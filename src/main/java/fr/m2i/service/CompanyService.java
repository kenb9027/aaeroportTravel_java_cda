package fr.m2i.service;

import fr.m2i.business.Company;

import java.util.ArrayList;

public interface CompanyService {

    Company getCompany(Long id);

    Company addCompany(String name);

    ArrayList<Company> getCompanies();
}
