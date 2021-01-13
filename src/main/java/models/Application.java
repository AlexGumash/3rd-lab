package models;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATION", schema = "EVENING")
public class Application {
    @Id
    @GeneratedValue
    @Column(name = "APPLICATION_ID")
    private int applicationId;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "SURNAME")
    private String surname;

    @Basic
    @Column(name = "PHONE")
    private String phone;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "EVCLASS_ID")
    private int evclassId;

    public Application() {
    }

    public Application(String name, String surname, String phone, String email, int evclassId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.evclassId = evclassId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEvclassId() {
        return evclassId;
    }

    public void setEvclassId(int evclassId) {
        this.evclassId = evclassId;
    }
}
