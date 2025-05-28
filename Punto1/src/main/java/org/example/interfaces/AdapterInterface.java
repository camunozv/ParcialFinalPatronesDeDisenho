package org.example.interfaces;

import org.example.otherClasses.Employee;

public interface AdapterInterface {

    Employee getEmployeeById(Long userId) throws Exception;
}
