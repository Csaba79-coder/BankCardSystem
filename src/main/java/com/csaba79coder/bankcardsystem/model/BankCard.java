package com.csaba79coder.bankcardsystem.model;

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
    private String bankCardNumber;

    private String maskedBankCardNumber;

    @Enumerated(EnumType.STRING)
    private TypeOfBankCard type;

    private String cvcCode;
    private String pinCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clients_id")
    private Client client;

    public BankCard(Client client) {
        this.bankCardNumber = generateBankCardNumber();
        this.type = generateType(bankCardNumber);
        this.maskedBankCardNumber = maskingBankCarNumber();
        this.cvcCode = generateSecretCode();
        this.pinCode = generateSecretCode();
        this.client = client;
    }

    private String maskingBankCarNumber() {
        return bankCardNumber.replaceAll("\\b(\\d{4})(\\d{8})(\\d{4})", "$1XXXXXXXX$3");
    }

    private String generateSecretCode () {
        return String.format("%04d", new Random().nextInt(10000));
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
            bankCardNumber.append("").append(generateSecretCode());
        }
        return String.valueOf(bankCardNumber);
    }
}
