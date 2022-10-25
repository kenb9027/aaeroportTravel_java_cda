package fr.m2i.dao;

public class Queries {

    // FLY
    public static final String FLY_CREATE = "INSERT INTO fly ( price, company, hourDeparture, hourArrival, airportDeparture, airportArrival) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String FLY_SORT_BY_PRICE = "SELECT * FROM fly ORDER BY price DESC";


    // COMPANY
    public static final String COMPANY_CREATE = "INSERT INTO company (name) VALUES (?)";
    public static final String COMPANY_FIND_BY_ID = "SELECT * FROM company WHERE id= ?";
    public static final String COMPANY_FIND_ALL = "SELECT * FROM company";

    // AIRPORT
    public static final String AIRPORT_CREATE = "INSERT INTO airport (name) VALUES (?)";
    public static final String AIRPORT_FIND_BY_ID = "SELECT * FROM airport WHERE id= ?";
    public static final String AIRPORT_FIND_ALL = "SELECT * FROM airport";

}
