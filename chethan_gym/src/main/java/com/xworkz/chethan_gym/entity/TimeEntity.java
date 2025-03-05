package com.xworkz.chethan_gym.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "time_slots")
@NamedQuery(name = "getAllSlots", query = "SELECT e FROM TimeEntity e")
public class TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String startTime;

    private String endTime;

    private String duration;
}
