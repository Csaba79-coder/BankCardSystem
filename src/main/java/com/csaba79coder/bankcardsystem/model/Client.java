package com.csaba79coder.bankcardsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // @Column(unique = true)
    private String email;

    private String name;
    private String mobile;

    @UpdateTimestamp
    private Timestamp creationTime;

    @OneToMany(mappedBy="client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<BankCard> bankCards;

    public Client(String email, String name, String mobile) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.creationTime = getTimeStamp();
        this.bankCards= new HashSet<>();
    }

    private Timestamp getTimeStamp() {
        Long datetime = System.currentTimeMillis();
        return new Timestamp(datetime);
    }
}

