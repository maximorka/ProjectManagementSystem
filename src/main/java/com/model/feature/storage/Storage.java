package com.model.feature.storage;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import static com.model.Model.DATABASE_CONNECTION_URL;

public class Storage {
    public static Storage getINSTANCE() {
        return INSTANCE;
    }
    public static final Storage INSTANCE = new Storage();
    private Connection connection;


    private Storage() {
        try {
            connection =  DriverManager.getConnection(DATABASE_CONNECTION_URL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
