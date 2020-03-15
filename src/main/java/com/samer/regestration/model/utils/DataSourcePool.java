package com.samer.regestration.model.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourcePool {

    private JeaQueue<ConnectionWrapper> connection;
    private String url;
    private String userName;
    private String password;

    public DataSourcePool(String url, String userName, String password) {
        this.connection = new JeaQueue<>(10);
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public ConnectionWrapper getConnection() throws SQLException {
        if (this.connection.isEmpty()) {
            return new ConnectionWrapper(DriverManager.getConnection(url, userName, password));
        } else {
            ConnectionWrapper connectionWrapper = this.connection.deQueue();
            if (connectionWrapper.isAlive()) {
                return connectionWrapper;
            } else {
                connectionWrapper.getConnection().close();
                return getConnection();
            }
        }
    }

}

