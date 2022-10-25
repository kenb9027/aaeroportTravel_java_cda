package fr.m2i.service.serviceImpl;

import fr.m2i.business.Company;
import fr.m2i.dao.CompanyDao;
import fr.m2i.dao.impl.CompanyDaoImpl;
import fr.m2i.service.CompanyService;
import fr.m2i.business.Company;
import fr.m2i.service.CompanyService;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompanyServiceImpl implements CompanyService {
    private static ArrayList<Company> companies = new ArrayList<Company>() ;

    private CompanyDao companyDao = new CompanyDaoImpl();
    @Override
    public Company getCompany(Long id) {

        try {
            return companyDao.findOneBy(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Company addCompany(String name) {
        Company newCompany = new Company(name);
//        companies.add(newCompany);
        try{
            companyDao.create(newCompany);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return newCompany;
    }

    @Override
    public ArrayList<Company> getCompanies() {

        try{
            return companyDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
