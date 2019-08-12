package com.example.demo.dto;

import com.example.demo.entity.Street;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

public class StreetDto {


    private int id;
    @NotNull
    @Size(min =6, max = 50)
    private String name;
    private String description;
    private long create_at;
    private int status;
    private int district;

    private String createAt;

    public StreetDto() {
    }

    public StreetDto(Street street) {
        this.id = street.getId();
        this.name = street.getName();
        this.description = street.getDescription();
        this.create_at = street.getCreate_at();
        this.status = street.getStatus();
        if (create_at > 0){
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(this.create_at);

            this.createAt = calendar.getTime().toString();
        }
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

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

}
