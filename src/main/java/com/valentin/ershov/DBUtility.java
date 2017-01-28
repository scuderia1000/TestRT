package com.valentin.ershov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Valek on 27.01.2017.
 */
public class DBUtility {
    private static final Logger LOG = LoggerFactory.getLogger(DBUtility.class);

    private static Connection connection = null;

    public static Connection getConnection() {
        String url = "jdbc:postgresql://127.0.0.1:5432/test_rt";
        String name = "postgres";
        String password = "postgres";
        if (connection != null) {
            return connection;
        } else {
            try {
//                Class.forName("com.mysql.jdbc.Driver");
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, name, password);
            } catch (Exception e) {
                LOG.info("Error create connection to db");
            }
        }
        return connection;
    }


}
