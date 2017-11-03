package com.admintool.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.admintool.model.Employee;


public interface EmployeeService {

    final static Map<Integer, Employee> employeeDataStore = new HashMap<Integer, Employee>() {
        {
            put(101, new Employee(101, "vishal singh", new Date()));
            put(102, new Employee(102, "shristi vijayvargiya", new Date()));
            put(103, new Employee(103, "amit kumar", new Date()));
            put(104, new Employee(104, "sonu singh", new Date()));
            put(105, new Employee(105, "monu singh", new Date()));
        }
    };
    public Employee getEmployee(int employeeId);
    public Employee deleteEmployee(int employeeId);
    public Employee createEmployee(Employee employee);
    public List<Employee> getEmployee();
}
