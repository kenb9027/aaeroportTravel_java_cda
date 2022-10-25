package fr.m2i.dao.impl;

import fr.m2i.business.Company;
import fr.m2i.dao.CompanyDao;
import fr.m2i.dao.ConnexionBDD;
import fr.m2i.dao.Queries;

import java.sql.*;
import java.util.ArrayList;



public class CompanyDaoImpl implements CompanyDao {

    private Connection connection;

    public CompanyDaoImpl()
    {
        try {
            connection = ConnexionBDD.getConnection();


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Company findOneBy(Long id) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.COMPANY_FIND_BY_ID
        );
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next())
        {
            Company company = new Company();
            company.setId(resultSet.getLong("id"));
            company.setName(resultSet.getString("name"));
            return company;
        }

        return null;
    }

    @Override
    public Company create(Company company) throws SQLException {
        //prepareStatement(2 params) = string pour la requete , id auto generé
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.COMPANY_CREATE ,
                Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, company.getName());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next())
        {
            company.setId(resultSet.getLong(1));
        };
        return company;
    }

    @Override
    public ArrayList<Company> findAll() throws SQLException {

        ArrayList<Company> companies = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(Queries.COMPANY_FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            Company company = new Company();
            company.setId(resultSet.getLong("id"));
            company.setName(resultSet.getString("name"));
            companies.add(company);
        }
        return companies;
    }
}
