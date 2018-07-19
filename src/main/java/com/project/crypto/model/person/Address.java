package com.project.crypto.model.person;

import com.project.crypto.utils.ConstantUtils;
import com.project.crypto.validators.Validate;

import javax.persistence.*;

/**
 * Created by Rafał on 2017-09-05.
 */
@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private long id;

    @Column(name = "address_city", nullable = false)
    @Validate(min = 1, max = 100, regexp = ConstantUtils.CHAR_PATTERN, message = "Please enter between {min} to {max} characters and no digits")
    private String city;

    @Column(name = "address_state", nullable = false, length = 100)
    private String state;

    @Column(name = "address_country", nullable = false, length = 100)
    private String country; //TODO country as ENUM

    @Column(name = "address_street", nullable = false, length = 300)
    private String street;

    @Column(name = "address_zipcode", nullable = false)
    private String zipcode;

    @ManyToOne
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
