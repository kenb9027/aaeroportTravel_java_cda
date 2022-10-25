package fr.m2i.dao.impl;

import fr.m2i.business.Fly;
import fr.m2i.dao.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FlyDaoImpl implements FlyDao {

    private Connection connection;
    private AirportDao airportDao = new AirportDaoImpl();
    private CompanyDao companyDao = new CompanyDaoImpl();

    public FlyDaoImpl()
    {
        try {
            //Teste la connexion à la BDD
            connection = ConnexionBDD.getConnection();
            //test de la connexion au autres DAO
            companyDao = new CompanyDaoImpl();
            airportDao = new AirportDaoImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Fly create(
            Fly fly
    )  throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
                Queries.FLY_CREATE,
                Statement.RETURN_GENERATED_KEYS
        );

        // Remplace les "?" de la requete par les parametres de l'objet FLY
        //parse les paramametres pour correspondre a la BDD
        statement.setFloat(1, fly.getPrice());
        statement.setLong(2, fly.getCompany().getId());
        statement.setLong(3 , fly.getAirportDeparture().getId());
        statement.setLong(4 , fly.getAirportArrival().getId());
        statement.setTime(5, fly.getHourDeparture());
        statement.setTime(6 , fly.getHourArrival());
        // Execute la requete
        statement.executeUpdate();
        //récupere l'ID généré en BDD
        ResultSet resultSet = statement.getGeneratedKeys();
        //s'il y a un resultat , on le précise sur l'objet
        if (resultSet.next()) {
            fly.setId(resultSet.getLong(1));
        }
        //retourne le Vol , si pas d'id, rien ne se passe (vol non enregistré
        return fly;
    }

    @Override
    public Fly findOneBy(long number) throws SQLException {
        return null;
    }


    @Override
    public ArrayList<Fly> findAll() throws SQLException {

        ArrayList<Fly> flies = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(
                Queries.FLY_SORT_BY_PRICE
        );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Fly fly = new Fly();
            fly.setPrice(resultSet.getFloat(1));
            fly.setCompany(companyDao.findOneBy(resultSet.getLong(2)));
            fly.setAirportDeparture(airportDao.findOneBy(resultSet.getLong(3)));
            fly.setAirportArrival(airportDao.findOneBy(resultSet.getLong(4 )));
            fly.setHourDeparture(resultSet.getTime(5));
            fly.setHourArrival(resultSet.getTime(6));

            flies.add(fly);


        }

        return flies;
    }
}
