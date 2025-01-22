package com.xworkz.chethan_gym.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "registration_table")
@NamedQuery(name = "getCountOfEmail", query = "SELECT COUNT(cme) FROM RegistrationEntity cme WHERE cme.email = :setEmail")
@NamedQuery(name = "updateDetailsByRegId", query = "UPDATE RegistrationEntity cme " + "SET cme.packages = :package, " + "    cme.trainer = :trainer, " + "    cme.amount = :amount, " + "    cme.paidAmount = :paidAmount, " + "    cme.balance = :balance " + "WHERE cme.reg_id = :reg_id")
@NamedQuery(name = "getAllEnquiriesRegistration", query = "SELECT cme FROM RegistrationEntity cme WHERE cme.email = :email")

public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reg_id")
    private int reg_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "ph")
    private String ph;

    @Column(name = "package")
    private String packages;

    @Column(name = "trainer")
    private String trainer;

    @Column(name = "gym_name")
    private String gymName;

    @Column(name = "amount")
    private String amount;

    @Column(name = "discount")
    private String discount;

    @Column(name = "balance")
    private String balance;

    @Column(name = "installment")
    private String installment;

    @Column(name = "password")
    private String password;

    @Column(name = "paid_Amount")
    private String paidAmount;


}
