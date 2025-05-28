package org.example.interfaces;

import org.example.utilities.Employee;
import java.net.http.HttpRequest;

public interface Adapter {

    Employee getEmployeeById(HttpRequest request) throws Exception;
}
