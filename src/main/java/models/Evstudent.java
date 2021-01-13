package models;

import javax.persistence.*;

@Entity
@Table(name = "EVSTUDENT", schema = "EVENING")
public class Evstudent {
    @Id
    @GeneratedValue
    @Column(name = "EVSTUDENT_ID")
    private int evstudentId;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "SURNAME")
    private String surname;

    @Basic
    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Basic
    @Column(name = "PHONE")
    private String phone;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "SOURCE")
    private String source;

    @Basic
    @Column(name = "SEND_MAILS")
    private Boolean sendMails;

    public Evstudent() {
    }

    public Evstudent(String name, String surname, String patronymic, String phone, String email, String source, Boolean sendMails) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.source = source;
        this.sendMails = true;
    }

    public int getEvstudentId() {
        return evstudentId;
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getSendMails() {
        return sendMails;
    }

    public void setSendMails(Boolean sendMails) {
        this.sendMails = sendMails;
    }
}
