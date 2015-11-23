/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.employeemanagement.entityview;

import com.leapfrog.employeemanagement.DAO.EmployeeDAO;
import static com.leapfrog.employeemanagement.Program.main;
import com.leapfrog.employeemanagement.entity.Employee;
import java.util.Scanner;
import com.leapfrog.employeemanagement.service.EmployeeService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author Bishal Aryal
 */
public class EmployeeView {

    private Scanner scanner;
    private EmployeeService employeeService;
    private Employee employee;

    public EmployeeView(Scanner scanner, EmployeeService employeeService) {
        this.scanner = scanner;
        this.employeeService = employeeService;
    }

    public void addScreen() {

        while (true) {
            System.out.println("===========================");
            System.out.println("Add Employee");
            System.out.println("===========================");
            employee = new Employee();

            System.out.print("Enter employee ID: ");
            employee.setId(scanner.nextInt());
            System.out.print("Enter employee firstname: ");
            employee.setFirstName(scanner.next());
            System.out.print("Enter employee lastname: ");
            employee.setLastName(scanner.next());
            System.out.print("Enter employee email: ");
            employee.setEmail(scanner.next());
            System.out.print("Enter employee contact: ");
            employee.setContact(scanner.next());
            System.out.print("Enter employee status: ");
            employee.setStatus(scanner.nextBoolean());

            employeeService.insert(employee);
            System.out.println("\nEmployee added!");

            System.out.print("Do you want to add more employee [y/n]? ");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    public void deleteScreen() {

        while (true) {
            System.out.println("===========================");
            System.out.println("Delete Employee");
            System.out.println("===========================");
            employee = new Employee();

            System.out.print("Enter employee ID: ");
            boolean success = employeeService.delete(scanner.nextInt());
            if (success = true) {
                System.out.println("Employee deleted!");
            } else {
                System.out.println("Delete unsuccessful.");
            }

            System.out.print("Do you want to delete more employee [y/n]? ");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    public void searchScreen() {
        employee = new Employee();

        System.out.println("===========================");
        System.out.println("Search Employees by ID");
        System.out.println("===========================");

        System.out.print("Enter employee ID: ");
        employee = employeeService.getById(scanner.nextInt());
        if (employee != null) {
            System.out.println("Employee found!");
            System.out.println(employee.toString());
        }

    }

    public void showScreen() {
        System.out.println("===========================");
        System.out.println("Showing all Employees");
        System.out.println("===========================");

        employeeService.getAll().forEach(e -> {
            System.out.println(e.toString());
        });

    }

    public void importScreen() {
        System.out.println("===========================");
        System.out.println("Importing from File");
        System.out.println("===========================");

        System.out.print("Enter path\\filename.ext: ");
        String path = scanner.next();
        File file = new File(path);
        
        employeeService.importEmployee(file);
        
    }
    
    public void exportScreen(){
        System.out.println("===========================");
        System.out.println("Exporting Duplicates");
        System.out.println("===========================");
        
        System.out.print("Enter export path\\filename.ext: ");
        String path = scanner.next();
        File file = new File(path);
        
        employeeService.exportEmployee(file);

    } 

}
