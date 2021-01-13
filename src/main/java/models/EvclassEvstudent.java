package models;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table (name = "EVCLASS_EVSTUDENT", schema = "EVENING")
public class EvclassEvstudent {
    @Id
    @GeneratedValue
    @Column(name = "EVCLASS_EVSTUDENT_ID")
    private int evclassEvstudentId;

    @Basic
    @Column(name = "EVCLASS_ID")
    private int evclassId;

    @Basic
    @Column(name = "EVSTUDENT_ID")
    private int evstudentId;

    @Basic
    @Column(name = "CONSULTATION_DATE")
    private Date consultationDate;

    @Basic
    @Column(name = "CONSULTATION_TIME")
    private Time consultationTime;

    @Basic
    @Column(name = "PAYMENT_STATE")
    private String paymentState;

    @Basic
    @Column(name = "CONTRACT_STATE")
    private String contractState;

    @Basic
    @Column(name = "STATUS")
    private String status;

    @Basic
    @Column(name = "COMMENT")
    private String comment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public EvclassEvstudent() {
        this.paymentState = "Не оплачено";
        this.contractState = "Не подписан";
    }

    public EvclassEvstudent(int evclassId, int evstudentId, Date consultationDate, Time consultationTime, String paymentState, String contractState, String status, String comment) {
        this.evclassId = evclassId;
        this.evstudentId = evstudentId;
        this.consultationDate = consultationDate;
        this.consultationTime = consultationTime;
        if (paymentState != "") {
            this.paymentState = paymentState;
        } else {
            this.paymentState = "Не оплачено";
        }

        if (contractState != "") {
            this.contractState = contractState;
        } else {
            this.contractState = "Не подписан";
        }
        this.status = status;
        this.comment = comment;
    }

    public EvclassEvstudent(int evclassId, int evstudentId) {
        this.evclassId = evclassId;
        this.evstudentId = evstudentId;
        this.consultationDate = null;
        this.consultationTime = null;
        this.paymentState = "Не оплачено";
        this.contractState = "Не подписан";
        this.status = "Не обработано";
        this.comment = null;
    }

    public int getEvclassEvstudentId() {
        return evclassEvstudentId;
    }

    public int getEvclassId() {
        return evclassId;
    }

    public void setEvclassId(int evclassId) {
        this.evclassId = evclassId;
    }

    public int getEvstudentId() {
        return evstudentId;
    }

    public void setEvstudentId(int evstudentId) {
        this.evstudentId = evstudentId;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public Time getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(Time consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public String getContractState() {
        return contractState;
    }

    public void setContractState(String contractState) {
        this.contractState = contractState;
    }
}
