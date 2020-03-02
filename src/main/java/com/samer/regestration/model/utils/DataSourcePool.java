package com.samer.regestration.model.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourcePool {

    private JeaQueue<ConnectionWrapper> connection;
    private String url;
    private String userName;
    private String password;

    public DataSourcePool() {
        this.connection = new JeaQueue<>(10);
    }

    public ConnectionWrapper getConnection(String url, String userName, String password) throws SQLException {
        if (this.connection.isEmpty()) {
            return new ConnectionWrapper(DriverManager.getConnection(url, userName, password));
        } else {
            ConnectionWrapper connectionWrapper = this.connection.deQueue();
            if (connectionWrapper.isAlive()) {
                return connectionWrapper;
            } else {
                connectionWrapper.getConnection().close();
                return getConnection(url, userName, password);
            }
        }
    }

}

