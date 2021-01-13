package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "EVCLASS", schema = "EVENING")
public class Evclass {
    @Id
    @GeneratedValue
    @Column(name = "EVCLASS_ID")
    private int evclassId;

    @Basic
    @Column(name = "EVCOURSE_ID")
    private int evcourseId;

    @Basic
    @Column(name = "DATE_BEGIN")
    private Date dateBegin;

    @Basic
    @Column(name = "DATE_END")
    private Date dateEnd;

    @Basic
    @Column(name = "PRICE")
    private int price;

    public Evclass() {
    }

    public Evclass(int evcourseId, Date dateBegin, Date dateEnd, int price) {
        this.evcourseId = evcourseId;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEvclassId() {
        return evclassId;
    }

    public int getEvcourseId() {
        return evcourseId;
    }

    public void setEvcourseId(int evcourseId) {
        this.evcourseId = evcourseId;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}
