package models;

import javax.persistence.*;

@Entity
@Table (name = "EVCOURSE", schema = "EVENING")
public class Evcourse {
    @Id
    @GeneratedValue
    @Column(name = "EVCOURSE_ID")
    private int evcourseId;

    @Basic
    @Column(name = "CODE")
    private String code;

    @Basic
    @Column(name = "NAME")
    private String name;

    @Basic
    @Column(name = "SHORTNAME")
    private String shortName;

    @Basic
    @Column(name = "VERSION")
    private String version;

    @Basic
    @Column(name = "DURATION")
    private int duration;

    @Basic
    @Column(name = "PRICE")
    private int price;

    public Evcourse() {
    }

    public Evcourse(String code, String name, String shortName, String version, int duration, int price) {
        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.version = version;
        this.duration = duration;
        this.price = price;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEvcourseId() {
        return evcourseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
