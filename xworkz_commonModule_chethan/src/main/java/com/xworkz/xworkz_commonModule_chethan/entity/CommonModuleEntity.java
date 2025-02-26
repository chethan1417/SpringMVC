package com.xworkz.xworkz_commonModule_chethan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "common_module_table")
@NamedQuery(name = "getCountOfName", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.name = :setName")
@NamedQuery(name = "getCountOfEmail", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.email = :setEmail")
@NamedQuery(name = "getCountOfPhone", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.ph = :setPh")
@NamedQuery(name = "getCountOfAlterEmail", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.alterEmail = :setAlterEmail")
@NamedQuery(name = "getCountOfAlterPhone", query = "SELECT COUNT(cme) FROM CommonModuleEntity cme WHERE cme.alterPh = :setAlterPhone")
@NamedQuery(name = "getValue", query = "SELECT cme FROM CommonModuleEntity cme WHERE LOWER(cme.email) = LOWER(:email)")
@NamedQuery(name = "updateDetailsByName", query = "UPDATE CommonModuleEntity cme SET cme.ph = :ph, cme.alterEmail = :alterEmail, cme.alterPh = :alterPh, cme.location = :location, cme.email = :email, cme.filePath = :filePathBy, cme.updatedDate = :updatedOn, cme.updatedBy = :updatedBy WHERE cme.name = :name")
@NamedQuery(name = "updatePasswordAndCountByEmail", query = "UPDATE CommonModuleEntity cme SET cme.password = :password, cme.signinCount = :signinCount, cme.loginTime = :loginTime WHERE cme.email = :email")


public class CommonModuleEntity extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "ph")
    private String ph;

    @Column(name = "alter_email")
    private String alterEmail;

    @Column(name = "alter_ph")
    private String alterPh;

    @Column(name = "location")
    private String location;

    @Column(name = "signin_count")
    private int signinCount;

    @Column(name = "login_time")
    private LocalDateTime loginTime;
}
