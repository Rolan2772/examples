package com.rolan.examples.editor.shared.dto;

public class PhoneBook {

    private Employee employee;
    private Contact contact;

    public PhoneBook(Employee employee, Contact contact) {
        this.employee = employee;
        this.contact = contact;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
