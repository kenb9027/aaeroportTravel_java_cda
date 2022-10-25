package fr.m2i.service.serviceImpl;

import fr.m2i.business.Airport;
import fr.m2i.dao.AirportDao;
import fr.m2i.dao.impl.AirportDaoImpl;
import fr.m2i.service.AirportService;
import fr.m2i.service.AirportService;

import java.sql.SQLException;
import java.util.ArrayList;

public class AirportServiceImpl implements AirportService {

    private static ArrayList<Airport> airports = new ArrayList<Airport>() ;

    private AirportDao airportDao = new AirportDaoImpl();

    @Override
    public Airport getAirport(Long id) {

        try {
            return airportDao.findOneBy(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airport addAirport(String name) {

        Airport newAirport = new Airport(name);
        airports.add(newAirport);
        return newAirport ;
    }

    @Override
    public ArrayList<Airport> getAirports() {

        try{
            return airportDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
