package fr.m2i.business;

import java.sql.Time;
import java.util.Comparator;

public class Fly {

    private long id;
    private float price ;
    private Company company;

    private Time hourDeparture;
    private Time hourArrival;
    private Airport airportDeparture;
    private Airport airportArrival;


    public Fly(
            float price,
            Company company,
            Time hourDeparture,
            Time hourArrival,
            Airport airportDeparture,
            Airport airportArrival) {
        this();
        this.price = price;
        this.company = company;
        this.hourDeparture = hourDeparture;
        this.hourArrival = hourArrival;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;

        this.company.getFlies().add(this);
        this.airportArrival.getFlies().add(this);
        this.airportDeparture.getFlies().add(this);
    }

    public Fly() {

    }


    @Override
    public String toString() {
        return "Fly{" +
                "number=" + id +
                ", price=" + price +
                ", company=" + company +
                ", hour Departure=" + hourDeparture +
                ", hour Arrival=" + hourArrival +
                ", airport Departure=" + airportDeparture +
                ", airport Arrival=" + airportArrival +
                '}';
    }

    public long getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Time getHourDeparture() {
        return hourDeparture;
    }

    public void setHourDeparture(Time hourDeparture) {
        this.hourDeparture = hourDeparture;
    }

    public Time getHourArrival() {
        return hourArrival;
    }

    public void setHourArrival(Time hourArrival) {
        this.hourArrival = hourArrival;
    }

    public Airport getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(Airport airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public Airport getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(Airport airportArrival) {
        this.airportArrival = airportArrival;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*
     * Comparator pour le tri des vols par prix
     */
//    public static Comparator<Fly> ComparatorPrice = new Comparator<Fly>() {
//
//        @Override
//        public int compare(Fly e1, Fly e2) {
//            return (int) (e1.getPrice() - e2.getPrice());
//        }
//    };

}
