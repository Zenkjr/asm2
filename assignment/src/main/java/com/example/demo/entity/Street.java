package com.example.demo.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Street {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private long create_at;
    private int status;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "districtId")
    private District district;

    public Street() {
        this.create_at = Calendar.getInstance().getTimeInMillis();
        this.status = 1;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Street(int id, String name, String description, long create_at, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.create_at = create_at;
        this.status = status;
    }
}
