package model;

import java.io.Serializable;
import java.time.LocalDate;

public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String address;
    private String phoneNumber;
    private String subject;
    private String username;
    private String password;
    private String role;

    public UserModel(String firstName, String lastName, LocalDate dob, String role, String email, String phoneNumber,
            String subject, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.subject = subject;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getRole() {
        return role;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSubject() {
        return subject;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
