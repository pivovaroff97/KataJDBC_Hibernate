package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/kata_test_db";
    private final static String DB_USERNAME = "root";
    private final static String DB_PASSWORD = "calm";
    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", DB_URL);
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        prop.setProperty("hibernate.connection.username", DB_USERNAME);
        prop.setProperty("hibernate.connection.password", DB_PASSWORD);
        prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.setProperty("show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
        sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .addProperties(prop).buildSessionFactory();
        return sessionFactory;
    }
}
