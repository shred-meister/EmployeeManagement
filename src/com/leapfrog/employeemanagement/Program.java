/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.employeemanagement;

import com.leapfrog.employeemanagement.entity.Employee;
import com.leapfrog.employeemanagement.entityview.EmployeeView;
import com.leapfrog.employeemanagement.service.EmployeeService;
import com.leapfrog.employeemanagement.service.EmployeeServiceImpl;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Bishal Aryal
 */
public class Program {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeServiceImpl();
        Scanner scanner = new Scanner(System.in);
        EmployeeView employeeView = new EmployeeView(scanner, employeeService);
        while (true) {
            System.out.println("===========================");
            System.out.println("Employee Management");
            System.out.println("===========================");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Search By Id");
            System.out.println("4. Show All");
            System.out.println("5. Import From File");
            System.out.println("6. Export Duplicate Employees");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            switch (scanner.nextInt()) {
                case 1:
                    employeeView.addScreen();
                    break;
                case 2:
                    employeeView.deleteScreen();
                    break;
                case 3:
                    employeeView.searchScreen();
                    break;
                case 4:
                    employeeView.showScreen();
                    break;
                case 5:
                    employeeView.importScreen();
                    break;
                case 6:
                    employeeView.exportScreen();
                    break;
                case 7:
                    System.exit(0);
            }

        }
    }

}
