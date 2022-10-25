package fr.m2i.dao.impl;

import fr.m2i.business.Airport;
import fr.m2i.dao.AirportDao;
import fr.m2i.dao.ConnexionBDD;
import fr.m2i.dao.Queries;

import java.sql.*;
import java.util.ArrayList;

public class AirportDaoImpl implements AirportDao {

    private Connection connection;

    public AirportDaoImpl() {
        try {
            connection = ConnexionBDD.getConnection();


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Airport findOneBy(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.AIRPORT_FIND_BY_ID
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
        {
            Airport airport = new Airport();
            airport.setId(resultSet.getLong("id"));
            airport.setName(resultSet.getString("name"));
            return airport;
        }

        return null;
    }

    @Override
    public Airport create(Airport airport) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                Queries.AIRPORT_CREATE,
                Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setString(1, airport.getName());
        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next())
        {
            airport.setId(resultSet.getLong(1));
        };
        return airport;
    }

    @Override
    public ArrayList<Airport> findAll() throws SQLException {
        ArrayList<Airport> airports = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(Queries.AIRPORT_FIND_ALL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Airport airport = new Airport();
            airport.setId(resultSet.getLong("id"));
            airport.setName(resultSet.getString("name"));
            airports.add(airport);
        }
        return airports;
    }
}
