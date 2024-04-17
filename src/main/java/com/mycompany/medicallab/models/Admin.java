package com.mycompany.medicallab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;

    public Admin() {}

    public String getPassword() {
        return password;
    }
}
