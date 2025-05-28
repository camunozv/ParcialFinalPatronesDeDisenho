package org.example;

import java.net.URI;
import java.net.http.HttpRequest;
import org.example.implementation.AdapterImpl;
import org.example.interfaces.Adapter;
import org.example.utilities.Employee;

public class Main {

    public static void main(String[] args) throws Exception {

        Adapter adapter = new AdapterImpl();

        String baseUrl = "https://custom-address.com";

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseUrl + "/?id=1"))
                .setHeader("User-Agent", "Java 17 HttpClient")
                .build();

        Employee soughtEmployee = adapter.getEmployeeById(request);

        System.out.println("User Found!");
        System.out.println("User Id: " + soughtEmployee.getId());
        System.out.println("User Name: " + soughtEmployee.getName());
        System.out.println("User Salary: " + soughtEmployee.getSalary());
    }
}
