/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.employeemanagement.entity;

/**
 *
 * @author Bishal Aryal
 */
public class Employee {
    private int id;
    private String firstName, lastName, email, contact;
    private boolean status;

    public Employee() {
    }
    
    public Employee(int id, String firstName, String LastName, String email, String contact, Boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName= lastName;
        this.email=email;
        this.contact=contact;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contact=" + contact + ", status=" + status + '}';
    }
    
    
    
}
