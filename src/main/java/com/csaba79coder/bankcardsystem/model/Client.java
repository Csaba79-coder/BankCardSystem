package com.csaba79coder.bankcardsystem.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;
    private String mobile;

    private Timestamp creationTime;

    public Client(String email, String name, String mobile) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.creationTime = getTimeStamp();
    }

    private Timestamp getTimeStamp() {
        long datetime = System.currentTimeMillis();
        return new Timestamp(datetime);
    }
}

