/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.employeemanagement.service;

import com.leapfrog.employeemanagement.DAO.DAOImpl.EmployeeDAOImpl;
import com.leapfrog.employeemanagement.DAO.EmployeeDAO;
import com.leapfrog.employeemanagement.entity.Employee;
import java.io.File;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Bishal Aryal
 */
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
    
    public EmployeeServiceImpl(){
        employeeDAO = new EmployeeDAOImpl(new Vector<>());
    }

    @Override
    public void insert(Employee e) {
        employeeDAO.insert(e);
    }

    @Override
    public boolean delete(int id) {
        return employeeDAO.delete(id);
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }
    
    @Override
    public void importEmployee(File file){
        employeeDAO.importEmployee(file);
    }
    
    @Override
    public void exportEmployee(File file){
        employeeDAO.exportEmployee(file);
    }
    
}
