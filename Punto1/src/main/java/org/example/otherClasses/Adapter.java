package org.example.otherClasses;

import org.example.interfaces.AdapterInterface;
import org.example.services.Service;

public class Adapter implements AdapterInterface {

    private Service adaptee;

    public void convertData() {
        // This method shall take a HttpRequest
        // and return a number, that then we will send to
        // our db service in the right format.
    }

    @Override
    public Employee getEmployeeById(Long userId) throws Exception {
        // This method shall receive information in a httpRequest way
        // and then convert it into sql code.

        //convertData(userId);

        // Brings data with sql code.
        // but its response shall be in http form
        //

        // We must translate the response to a
        return adaptee.serviceMethod(userId);
    }
}
