package fr.m2i;

import fr.m2i.business.Airport;
import fr.m2i.service.AirportService;
import fr.m2i.service.serviceImpl.AirportServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello there!");

        AirportService airportService = new AirportServiceImpl();
        ArrayList<Airport> airports = airportService.getAirports();
        System.out.println(airports);
    }
}