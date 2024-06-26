package com.mycompany.medicallab.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "fName", length = 25)
    private String fName;

    @Column(name = "lName", length = 25)
    private String lName;

    @Column(name = "cin", length = 12, unique = true)
    private String cin;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "gender", length = 6)
    private String gender;

    //This annotation ensures that only the date portion of the Date object is stored in the database, without considering the time component.
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    // linking appointments to patient with hibernate so one patient with many appointments 
    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments = new HashSet<>();

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    // toString method for debugging reasons
    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", cin=" + cin + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", birthdate=" + birthdate + '}';
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
}
