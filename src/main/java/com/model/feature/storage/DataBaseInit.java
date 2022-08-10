package com.model.feature.storage;
import org.flywaydb.core.Flyway;

public class DataBaseInit {
    public void initDB(String connectionUrl){
        System.out.println("Init db");
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl,null, null).load();
        flyway.migrate();
    }
}
