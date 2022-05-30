package com.csaba79coder.bankcardsystem.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bankcards")
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankCardNumber;

    @Enumerated(value = EnumType.ORDINAL)
    private TypeOfBankCard type;

    private String secretCode;

    @ManyToOne
    private Client client;
}
