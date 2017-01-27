package com.valentin.ershov;

/**
 * Created by Танюша on 27.01.2017.
 */
public class Car {
    private Integer id;
    private Integer userId;
    private String model;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
