package fr.m2i.dao;

import fr.m2i.business.Fly;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface FlyDao {

    Fly create(
            Fly fly
    ) throws SQLException;

    Fly findOneBy(long number) throws SQLException;

    ArrayList<Fly> findAll() throws SQLException;
}
