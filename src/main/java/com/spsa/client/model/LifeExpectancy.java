package com.spsa.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spsa.client.util.Constant;

import java.util.Date;

public class LifeExpectancy {

    @JsonProperty("sex")
    private Constant.Gender gender;
    private String country;
    @JsonProperty("dob")
    private Date birthday;
    @JsonProperty("total_life_expectancy")
    private Double totalLifeExpectancy;

    public Constant.Gender getGender() {
        return gender;
    }

    public void setGender(Constant.Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getTotalLifeExpectancy() {
        return totalLifeExpectancy;
    }

    public void setTotalLifeExpectancy(Double totalLifeExpectancy) {
        this.totalLifeExpectancy = totalLifeExpectancy;
    }

    @Override
    public String toString() {
        return "TotalLifeExpectancy{" +
                "gender=" + gender +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", totalLifeExpectancy=" + totalLifeExpectancy +
                '}';
    }
}
