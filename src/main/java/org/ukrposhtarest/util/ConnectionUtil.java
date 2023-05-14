package org.ukrposhtarest.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Service
public class ConnectionUtil {

    @Autowired
    private static Environment environment;

    public static Connection getConnection() {
        String url = environment.getProperty("spring.datasource.url");
        String username = environment.getProperty("spring.datasource.username");
        String password = environment.getProperty("spring.datasource.password");
        String driverClassName = environment.getProperty("spring.datasource.driver-class-name");

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Не удалось найти драйвер SQL", e);
        }

        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", username);
        dbProperties.setProperty("password", password);

        try {
            assert url != null;
            return DriverManager.getConnection(url, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось создать соединение с базой данных", e);
        }
    }
}

