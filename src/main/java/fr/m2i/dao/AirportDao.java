package fr.m2i.dao;

import fr.m2i.business.Airport;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AirportDao {

    Airport findOneBy(Long id) throws SQLException;
    Airport create(Airport airport) throws SQLException;

    ArrayList<Airport> findAll() throws SQLException;
}
