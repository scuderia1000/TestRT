package com.valentin.ershov;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Valek on 27.01.2017.
 */
public class User {
    private Integer id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String city;
    private Set<String> carModels = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCarModel(String model) {
        carModels.add(model);
    }

    public Set<String> getCarModels() {
        return carModels;
    }

    public void setCarModels(Set<String> carModels) {
        this.carModels = carModels;
    }
}
