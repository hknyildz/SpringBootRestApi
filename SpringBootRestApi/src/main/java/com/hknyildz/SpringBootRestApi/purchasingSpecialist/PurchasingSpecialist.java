package com.hknyildz.SpringBootRestApi.purchasingSpecialist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hknyildz.SpringBootRestApi.bill.Bill;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
        (
                name = "PurchasingSpecialist",
                uniqueConstraints = {
                        @UniqueConstraint(name = "ps_email_unique", columnNames = "email")
                }

        )
@AllArgsConstructor
public class PurchasingSpecialist {

    @SequenceGenerator(
            name = "ps_sequence",
            sequenceName = "ps_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ps_sequence"
    )
    @Id
    private Long Id;
    @Column(
            name = "FirstName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "LastName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private List<Bill> bills;

    public PurchasingSpecialist() {
    }

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

}
