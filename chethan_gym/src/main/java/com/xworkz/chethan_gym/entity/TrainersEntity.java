package com.xworkz.chethan_gym.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "trainers_table")
@NamedQuery(name = "getAllTrainers", query = "SELECT e FROM TrainersEntity e")
@NamedQuery(name = "updateSlotsByName", query = "UPDATE TrainersEntity cme SET cme.slots = :slots WHERE cme.name = :name")
@NamedQuery(name = "deleteTrainerByName", query = "DELETE FROM TrainersEntity cme WHERE cme.name = :name")

public class TrainersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String ph;

    private String slots;

}
