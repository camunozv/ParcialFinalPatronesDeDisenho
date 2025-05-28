package org.example.services;

/*
 * This class contains a serviceMethod(), and should return
 * user info, based on a sql syntax.
 * */

import org.example.otherClasses.Employee;

import java.sql.*;

public class Service {

    private static final String DB_URL = "jdbc:postgresql://shinkansen.proxy.rlwy.net:34049/railway";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "gRfGLFjvVjYImqUHnqiEBGIEvtfrVzQp";

    private static final String JDBC_DRIVER = "org.postgresql.Driver"; // For PostgreSQL

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public Employee serviceMethod(Long userId) throws Exception {

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("JDBC Driver loaded.");

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection successful!");

            statement = connection.createStatement();

            String sql = "SELECT * FROM Employee WHERE id = " + userId;
            System.out.println("Executing query: " + sql);
            resultSet = statement.executeQuery(sql);

            int columnCount = resultSet.getMetaData().getColumnCount();

            Employee employee = new Employee();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object columnValue = resultSet.getObject(i);
                    if (i == 1) {
                        employee.setId(Long.parseLong(columnValue.toString()));
                    } else if (i == 2) {
                        employee.setName(columnValue.toString());
                    } else {
                        employee.setSalary(columnValue.toString());
                    }
                }
            }

            System.out.println("User Found!");
            System.out.println("User Id: " + employee.getId());
            System.out.println("User Name: " + employee.getName());
            System.out.println("User Salary: " + employee.getSalary());

            connection.close();
            return employee;

        } catch (Exception e) {
            connection.close();
            throw new RuntimeException(e);
        }

    }
}

