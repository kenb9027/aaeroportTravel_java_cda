package fr.m2i.service;

import fr.m2i.business.Fly;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface FlyService {

    Fly addFly(
            float price,
            Long companyId,
            Time hourDeparture,
            Time hourArrival,
            Long airportDepartureId,
            Long airportArrivalId
    );

    Fly getFly(long number);

    ArrayList<Fly> getFlies();
}
