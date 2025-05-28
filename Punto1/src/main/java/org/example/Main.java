package org.example;

import org.example.services.Service;

public class Main {
    public static void main(String[] args) throws Exception {

        Service service = new Service();
        service.serviceMethod(1L);
    }
}
