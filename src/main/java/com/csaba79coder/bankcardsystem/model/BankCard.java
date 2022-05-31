package com.csaba79coder.bankcardsystem.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Random;

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

    @Column(unique = true)
    @JsonIgnore
    private String bankCardNumber;

    private String maskedBankCardNumber;

    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private TypeOfBankCard type;

    private String cvcCode;
    @JsonIgnore
    private String pinCode;

    private String nameOfOwner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clients_id")
    @JsonIgnore
    private Client client;

    public BankCard(Client client) {
        this.bankCardNumber = generateBankCardNumber();
        this.type = generateType(bankCardNumber);
        this.maskedBankCardNumber = maskingBankCarNumber();
        this.cvcCode = generateCVC();
        this.pinCode = generateFourDigitNumber();
        this.client = client;
        this.nameOfOwner = client.getName();
    }

    private String maskingBankCarNumber() {
        return bankCardNumber.replaceAll("\\b(\\d{4})(\\d{8})(\\d{4})", "$1XXXXXXXX$3");
    }

    private String generateFourDigitNumber() {
        return String.format("%04d", new Random().nextInt(10000));
    }

    private String generateCVC() {
        return String.format("%03d", new Random().nextInt(1000));
    }

    private TypeOfBankCard generateType(String bankCardNumber) {
        if (bankCardNumber.startsWith("5")) {
            return TypeOfBankCard.MASTERCARD;
        } else if (bankCardNumber.startsWith("4")) {
            return TypeOfBankCard.VISA;
        } else if (bankCardNumber.startsWith("3")) {
            return TypeOfBankCard.AMERICAN_EXPRESS;
        } else {
            return TypeOfBankCard.OTHER;
        }
    }

    private String generateBankCardNumber()  {
        StringBuilder bankCardNumber = new StringBuilder("5440");
        for (int i = 0; i < 3; i++) {
            bankCardNumber.append("").append(generateFourDigitNumber());
        }
        return String.valueOf(bankCardNumber);
    }
}
