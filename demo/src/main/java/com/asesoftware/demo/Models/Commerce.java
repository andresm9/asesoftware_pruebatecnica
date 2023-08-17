package com.asesoftware.demo.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "commerce")
public class Commerce {
    @Id
    @Column(name = "commerce_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "commerce_name")
    private String Name;

    @Column(name = "max_capacity")
    private int maxCapacity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public Commerce() {
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public Commerce(long id, String name, int maxCapacity) {
        this.id = id;
        Name = name;
        this.maxCapacity = maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
