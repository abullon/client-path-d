package com.spsa.client.model;

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument;
import com.github.fabiomaffioletti.firebase.document.FirebaseId;
import com.spsa.client.util.Constant;
import com.spsa.client.util.DateUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@FirebaseDocument("/clients")
public class Client {

    @FirebaseId
    private String id;
    @NotNull(message = "El nombre es obligatorio")
    private String firstName;
    @NotNull(message = "El apellido es obligatorio")
    private String lastName;
    private Integer age;
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private Date birthday;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "El genero es obligatorio")
    private Constant.Gender gender;
    @NotNull(message = "El país es obligatorio")
    private String country;
    private Date probableDeathDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return DateUtils.calculateAge(DateUtils.convertToLocalDateViaInstant(birthday),LocalDate.now());
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

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

    public Date getProbableDeathDate() {
        return probableDeathDate;
    }

    public void setProbableDeathDate(Date probableDeathDate) {
        this.probableDeathDate = probableDeathDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", probableDeathDate=" + probableDeathDate +
                '}';
    }
}
