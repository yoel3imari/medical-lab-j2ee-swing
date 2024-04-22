/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicallab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author yusef
 */


@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "label", length = 50)
    private String label;

    @Column(name = "price")
    private double price;

    @Column(name = "days_to_get_result")
    private int daysToGetResult;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "type", length = 50)
    private String type;

    // Constructors, getters, and setters

    public Test() {
    }

    public Test(String label, double price, int daysToGetResult, String description, String type) {
        this.label = label;
        this.price = price;
        this.daysToGetResult = daysToGetResult;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDaysToGetResult() {
        return daysToGetResult;
    }

    public void setDaysToGetResult(int daysToGetResult) {
        this.daysToGetResult = daysToGetResult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
