package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "SEMINAR_EVSTUDENT", schema = "EVENING")
public class SeminarEvstudent {
    @Id
    @GeneratedValue
    @Column(name = "SEMINAR_EVSTUDENT_ID")
    private int seminarEvstudentId;

    @Basic
    @Column(name = "SEMINAR_ID")
    private int seminarId;

    @Basic
    @Column(name = "EVSTUDENT_ID")
    private int evstudentId;

    @Basic
    @Column(name = "PAYMENT_STATE")
    private String paymentState;

    public SeminarEvstudent() {
        this.paymentState = "Не оплачено";
    }

    public SeminarEvstudent(int seminarId, int evstudentId, String paymentState) {
        this.seminarId = seminarId;
        this.evstudentId = evstudentId;
        if (paymentState != "") {
            this.paymentState = paymentState;
        } else {
            this.paymentState = "Не оплачено";
        }

    }

    public int getSeminarEvstudentId() {
        return seminarEvstudentId;
    }

    public int getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(int seminarId) {
        this.seminarId = seminarId;
    }

    public int getEvstudentId() {
        return evstudentId;
    }

    public void setEvstudentId(int evstudentId) {
        this.evstudentId = evstudentId;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

}

