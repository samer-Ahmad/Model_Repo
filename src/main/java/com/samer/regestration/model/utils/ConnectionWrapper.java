package com.samer.regestration.model.utils;

import java.sql.Connection;
import java.time.LocalDateTime;

public class ConnectionWrapper {
    private Connection connection;
    private LocalDateTime creationDateTime;

    public ConnectionWrapper(Connection connection) {
        this.connection = connection;
        this.creationDateTime = LocalDateTime.now();
    }

    public boolean isAlive() {
        return this.creationDateTime.plusHours(6).compareTo(LocalDateTime.now()) >= 0;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
