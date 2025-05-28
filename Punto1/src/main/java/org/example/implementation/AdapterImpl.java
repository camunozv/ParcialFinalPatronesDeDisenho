package org.example.implementation;

import java.net.http.HttpRequest;

import org.example.interfaces.Adapter;
import org.example.services.Service;
import org.example.utilities.Employee;

public class AdapterImpl implements Adapter {

    private Service adaptee;

    public AdapterImpl() {
        this.adaptee = new Service();
    }

    @Override
    public Employee getEmployeeById(HttpRequest request) throws Exception {
        // This method shall receive information in a httpRequest way
        // and then convert it into a suitable format for the service
        // class represented by the adaptee object.

        // Data conversion, adapting occurs here.
        Long userId = Long.parseLong(String.valueOf(request.uri().toString().toCharArray()[31]));

        return adaptee.getUserByIdService(userId);
    }
}
