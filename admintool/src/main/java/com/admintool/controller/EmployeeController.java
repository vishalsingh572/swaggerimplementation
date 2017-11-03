package com.admintool.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admintool.model.Employee;
import com.admintool.service.EmployeeService;

@Controller
@Api(value = "EmployeeController", description = "Employee Operation")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


   @Autowired
   private EmployeeService employeeService;


    @ApiOperation(value = "Get the Employee Based on supplied id ", nickname = "getEmployee", code = 200, httpMethod = "GET"
            , notes = "Return the matched Employee", response = Employee.class, responseContainer = "Employee")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful Response Send", responseContainer = "Employee")
            , @ApiResponse(code = 404, message = "Employees not found")
            , @ApiResponse(code = 500, message = "Server Error")})
    @RequestMapping(value = "/rest/emp/{id}"
            , produces = "application/json"
            , method = RequestMethod.GET)
    public
    @ResponseBody
    Employee getEmployee(@ApiParam(value = "ID of employee", required = true) @PathVariable("id") int empId) {
        logger.info("Start getEmployee. ID=" + empId);
        return this.employeeService.getEmployee(empId);
    }


    @ApiOperation(value = "Get the List of Employee ", nickname = "getEmployees", code = 200, httpMethod = "GET"
            , notes = "Return the List of the Employee" , response = List.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful Response Send", responseContainer = "List<Employee>")
            , @ApiResponse(code = 404, message = "Employees not found")
            , @ApiResponse(code = 500, message = "Server Error")})
    @RequestMapping(value = "/rest/emps"
            , produces = "application/json"
            , method = RequestMethod.GET)
    public
    @ResponseBody
    List<Employee> getAllEmployees() {
        logger.info("Start getAllEmployees.");
        return this.employeeService.getEmployee();
    }


    @ApiOperation(value = "Create New Employee", nickname = "createEmployee", notes = "Create the Employee", httpMethod = "POST"
            , response = Employee.class, responseContainer = "Employee")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Employee Exist")
            , @ApiResponse(code = 404, message = "Employee Exist")
            , @ApiResponse(code = 200, message = "Employee Created", responseContainer = "Employee")})
    @RequestMapping(value = "/rest/emp/create"
            , produces = "application/json"
            , consumes = "application/json"
            , method = RequestMethod.POST)
    public
    @ResponseBody
    Employee createEmployee(@RequestBody Employee emp) {
        logger.info("Start createEmployee.");
        return this.employeeService.createEmployee(emp);
    }


    @ApiOperation(value = "Employee", nickname = "employee", notes = "Delete the Employee"
            , httpMethod = "DELETE", response = Employee.class, responseContainer = "Employee")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid ID supplied")
            , @ApiResponse(code = 404, message = "Employee not found")})
    @RequestMapping(value = "/rest/emp/delete/{id}"
            , produces = "application/json"
            , method = RequestMethod.DELETE)
    public
    @ResponseBody
    Employee deleteEmployee(@ApiParam(value = "ID of deleteEmployee", required = true) @PathVariable("id") int empId) {
        logger.info("Start deleteEmployee.");
        return this.employeeService.deleteEmployee(empId);
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHome(ModelMap modelMap) {
        modelMap.put("serverTime", new Date());
        return "home";
    }
}

