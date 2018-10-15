package ru.degtyar.springboot.model;

import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {

    @Id
    @NonNull
    private String id = UUID.randomUUID().toString();

    @Column
    private String firstName;

    @Column
    private String middleName;

    @Column
    private String secondName;

    @Column
    private String email;

    public Person(){}

    public Person(String firstName, String secondName, String middleName, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.email = email;
    }

    public String getId() {
        return id;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
