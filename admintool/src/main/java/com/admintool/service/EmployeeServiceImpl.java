package com.admintool.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.admintool.model.Employee;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    public Employee getEmployee(int employeeId){
        return employeeDataStore.get(employeeId);
    }

    public List<Employee> getEmployee() {
        List<Employee> emps = new ArrayList<Employee>();
        Set<Integer> empIdKeys = employeeDataStore.keySet();
        for (Integer i : empIdKeys) {
            emps.add(employeeDataStore.get(i));
        }
        return emps;
    }

    public Employee createEmployee( Employee employee) {
        employee.setCreatedDate(new Date());
        employeeDataStore.put(employee.getId(), employee);
        return employee;
    }

    public Employee deleteEmployee(int employeeId) {
        Employee emp = employeeDataStore.get(employeeId);
        return employeeDataStore.remove(employeeId);
    }
}
