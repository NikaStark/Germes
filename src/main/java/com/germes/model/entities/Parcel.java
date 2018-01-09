package com.germes.model.entities;

import com.germes.model.entities.enums.Status;

import java.util.Date;
import java.util.UUID;

public class Parcel implements Identified<UUID> {

    public static final String TABLE_NAME = "parcels";
    public static final String ID_COLUMN = "id";
    public static final String SENDER_COLUMN = "id_sender";
    public static final String RECEIVER_COLUMN = "id_receiver";
    public static final String BRANCH_SENDER_COLUMN = "id_branch_sender";
    public static final String BRANCH_RECEIVER_COLUMN = "id_branch_receiver";
    public static final String ISSUE_DATE_COLUMN = "issue_date";
    public static final String STATUS_COLUMN = "status";
    public static final String IS_PAID_COLUMN = "is_paid";
    public static final String PRICE_TOTAL_COLUMN = "price_total";

    private UUID id = new UUID(new Date().getTime(), -new Date().getTime());
    private UUID sender;
    private UUID receiver;
    private Integer branchSender;
    private Integer branchReceiver;
    private Date issueDate;
    private Status status;
    private Boolean isPaid;
    private Float priceTotal;

    public Parcel() {
    }

    public Parcel(UUID id, UUID sender, UUID receiver, Integer branchSender, Integer branchReceiver, Date issueDate, Status status, Boolean isPaid, Float priceTotal) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.branchSender = branchSender;
        this.branchReceiver = branchReceiver;
        this.issueDate = issueDate;
        this.status = status;
        this.isPaid = isPaid;
        this.priceTotal = priceTotal;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSender() {
        return sender;
    }

    public void setSender(UUID sender) {
        this.sender = sender;
    }

    public UUID getReceiver() {
        return receiver;
    }

    public void setReceiver(UUID receiver) {
        this.receiver = receiver;
    }

    public Integer getBranchSender() {
        return branchSender;
    }

    public void setBranchSender(Integer branchSender) {
        this.branchSender = branchSender;
    }

    public Integer getBranchReceiver() {
        return branchReceiver;
    }

    public void setBranchReceiver(Integer branchReceiver) {
        this.branchReceiver = branchReceiver;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Float priceTotal) {
        this.priceTotal = priceTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parcel parcel = (Parcel) o;

        if (!id.equals(parcel.id)) return false;
        if (!sender.equals(parcel.sender)) return false;
        if (!receiver.equals(parcel.receiver)) return false;
        if (!branchSender.equals(parcel.branchSender)) return false;
        if (!branchReceiver.equals(parcel.branchReceiver)) return false;
        if (!issueDate.equals(parcel.issueDate)) return false;
        if (status != parcel.status) return false;
        if (!isPaid.equals(parcel.isPaid)) return false;
        return priceTotal.equals(parcel.priceTotal);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + sender.hashCode();
        result = 31 * result + receiver.hashCode();
        result = 31 * result + branchSender.hashCode();
        result = 31 * result + branchReceiver.hashCode();
        result = 31 * result + issueDate.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + isPaid.hashCode();
        result = 31 * result + priceTotal.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", branchSender=" + branchSender +
                ", branchReceiver=" + branchReceiver +
                ", issueDate=" + issueDate +
                ", status=" + status +
                ", isPaid=" + isPaid +
                ", priceTotal=" + priceTotal +
                '}';
    }

}
