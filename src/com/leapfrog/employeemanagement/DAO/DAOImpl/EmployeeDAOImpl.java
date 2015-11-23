/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.employeemanagement.DAO.DAOImpl;

import com.leapfrog.employeemanagement.DAO.EmployeeDAO;
import com.leapfrog.employeemanagement.entity.Employee;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bishal Aryal
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private List<Employee> employeeList;
    //private List<Employee> tempList;
    private List<String> emailList = new ArrayList<>();

    public EmployeeDAOImpl(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public void insert(Employee e) {
        employeeList.add(e);
    }

    @Override
    public boolean delete(int id) {
        boolean success = false;
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                employeeList.remove(e);
                success = true;
                break;
            }
        }
        return success;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        for (Employee e : employeeList) {
            if (e.getId() == id) {
                employee = e;
            }
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public void importEmployee(File file) {
        String line = "";
        int flag = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, ",");
                if (tokens.countTokens() >= 6) {
                    Employee e = new Employee();
                    e.setId(Integer.parseInt(tokens.nextToken()));
                    e.setFirstName(tokens.nextToken());
                    e.setLastName(tokens.nextToken());
                    e.setEmail(tokens.nextToken());
                    e.setContact(tokens.nextToken());
                    e.setStatus(Boolean.parseBoolean(tokens.nextToken()));
                    employeeList.add(e);
                    flag = 1;

                }
            }
            reader.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        if (flag != 0) {
            System.out.println("Employees imported from file!");
            employeeList.forEach(e -> {
                System.out.println(e.toString());
            });
        }
    }

    @Override
    public void exportEmployee(File file) {

        Set<String> duplicates = new HashSet();
        Set<String> set = new HashSet();
        int flag = 0;

        for (Employee e : employeeList) {
            emailList.add(e.getEmail());
        }

        for (String email : emailList) {
            if (!set.add(email)) {
                duplicates.add(email);
                flag = 1;
            }
        }

        try {
            FileWriter fw = new FileWriter(file);
            for (String email : duplicates) {
                fw.write(email + "\r\n");
            }
            fw.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        if (flag != 0) {
            System.out.println("The following email(s) were found duplicate!");
            System.out.println(duplicates);
            System.out.println("\nDuplicates exported to file.");
            /*try {
                String line = "";
                BufferedReader reader = new BufferedReader(new FileReader(file));
                for (Employee e : tempList) {
                    while ((line = reader.readLine()) != null) {
                        if (line.equals(e.getEmail())) {
                            employeeList.remove(e);
                        }

                    }
                }
                reader.close();
                System.out.println("Employees with duplicate emails are now removed.");
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }*/

        }

    }

}
