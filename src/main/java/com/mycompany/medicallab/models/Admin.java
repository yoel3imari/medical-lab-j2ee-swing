package com.mycompany.medicallab.models;

import jakarta.persistence.*;

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
