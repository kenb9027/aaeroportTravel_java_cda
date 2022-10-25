package fr.m2i.dao;

import fr.m2i.business.Company;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CompanyDao {

    Company findOneBy(Long id) throws SQLException;

    Company create(Company company) throws SQLException;

    ArrayList<Company> findAll() throws SQLException;
}
