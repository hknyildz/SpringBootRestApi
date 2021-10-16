package com.hknyildz.SpringBootRestApi.bill;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hknyildz.SpringBootRestApi.dto.BillDto;
import com.hknyildz.SpringBootRestApi.purchasingSpecialist.PurchasingSpecialist;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
public class Bill {

    @SequenceGenerator(
            name = "bill_sequence",
            sequenceName = "bill_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bill_sequence"
    )
    @Id
    private Long id;
    private Integer amount;
    private String productName;
    private boolean accepted = true;
    private String billNo;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PurchasingSpecialist owner;
    public Bill(Integer amount, String productName, boolean accepted, String billNo, PurchasingSpecialist owner) {
        this.amount = amount;
        this.productName = productName;
        this.accepted = accepted;
        this.billNo = billNo;
        this.owner = owner;
    }

    public Bill() {
    }

    public Bill(BillDto billDto, PurchasingSpecialist owner) {
        this.amount = billDto.getAmount();
        this.productName = billDto.getProductName();
        this.owner = owner;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public boolean getAccepted() { return accepted; }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public PurchasingSpecialist getOwner() {
        return owner;
    }

    public void setOwner(PurchasingSpecialist owner) {
        this.owner = owner;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", productName='" + productName + '\'' +
                ", accepted=" + accepted +
                ", billNo='" + billNo + '\'' +
                ", owner=" + owner +
                '}';
    }
}
