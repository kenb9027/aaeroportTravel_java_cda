package fr.m2i.service.serviceImpl;

import fr.m2i.business.Fly;

import fr.m2i.dao.FlyDao;
import fr.m2i.dao.impl.FlyDaoImpl;
import fr.m2i.service.FlyService;


import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class FlyServiceImpl implements FlyService {

    private static ArrayList<Fly> flies = new ArrayList<Fly>() ;
    private FlyDao flyDao = new FlyDaoImpl();
    AirportServiceImpl airportService = new AirportServiceImpl() ;
    CompanyServiceImpl companyService = new CompanyServiceImpl() ;


    @Override
    public Fly addFly(float price,
                      Long companyId,
                      Time hourDeparture,
                      Time hourArrival,
                      Long airportDepartureId,
                      Long airportArrivalId) {

        Fly newFly = new Fly();
        newFly.setPrice(price);
        newFly.setCompany(companyService.getCompany(companyId));
        newFly.setAirportDeparture(airportService.getAirport(airportDepartureId));
        newFly.setAirportArrival(airportService.getAirport(airportArrivalId));
        newFly.setHourDeparture(hourDeparture);
        newFly.setHourArrival(hourArrival);

//        flies.add(newFly);

        try{
            flyDao.create(newFly);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newFly;
    }

    @Override
    public Fly getFly(long number) {
        for (Fly fly :
                flies) {
            if (fly.getNumber() == number) {
                return fly;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Fly> getFlies() {
        try{
            return flyDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
