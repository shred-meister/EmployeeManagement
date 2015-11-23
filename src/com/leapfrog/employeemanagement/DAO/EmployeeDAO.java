/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.employeemanagement.DAO;

import com.leapfrog.employeemanagement.entity.Employee;
import java.io.File;
import java.util.List;

/**
 *
 * @author Bishal Aryal
 */
public interface EmployeeDAO {
    void insert(Employee e);
    boolean delete(int id);
    Employee getById(int id);
    List<Employee> getAll();
    void importEmployee(File file);
    void exportEmployee(File file);
}
