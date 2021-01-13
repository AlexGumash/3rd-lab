package models;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;

@Entity
@Table (name = "SEMINAR", schema = "EVENING")
public class Seminar {
    @Id
    @GeneratedValue
    @Column(name = "SEMINAR_ID")
    private int seminarId;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "SHORT_NAME")
    private String shortName;

    @Basic
    @Column(name = "SEMINAR_DATE")
    private Date seminarDate;

    @Basic
    @Column(name = "SEMINAR_TIME")
    private Time seminarTime;

    @Basic
    @Column(name = "DURATION")
    private int duration;

    @Basic
    @Column(name = "PRICE")
    private int price;

    public Seminar() {
    }

    public Seminar(String name, String shortName, Date seminarDate, Time seminarTime, int duration, int price) {
        this.name = name;
        this.shortName = shortName;
        this.seminarDate = seminarDate;
        this.seminarTime = seminarTime;
        this.duration = duration;
        this.price = price;
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Date getSeminarDate() {
        return seminarDate;
    }

    public void setSeminarDate(Date seminarDate) {
        this.seminarDate = seminarDate;
    }

    public Time getSeminarTime() {
        return seminarTime;
    }

    public void setSeminarTime(Time seminarTime) {
        this.seminarTime = seminarTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

