package fr.m2i.service;

import fr.m2i.business.Airport;

import java.util.ArrayList;

public interface AirportService {

    Airport getAirport(Long id);
    Airport addAirport(String name);

    ArrayList<Airport> getAirports();
}
