package com.example.zoologico.models;

import com.example.zoologico.enums.JobTitle;
import com.example.zoologico.interfaces.SystemUser;

public class Employee implements SystemUser {
    private String id, fullName, email, password;
    private float salary;
    private JobTitle position;

    public Employee() {
    }

    public Employee(String id, String fullName, String email, String password, float salary, JobTitle position) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public JobTitle getPosition() {
        return position;
    }

    public void setPosition(JobTitle position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean logIn(String email, String password) {
        if (this.email.equals(email) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
}
