package com.csaba79coder.bankcardsystem.dto;

import com.csaba79coder.bankcardsystem.model.Client;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankCardMaskingDto {

    private String maskedBankCardNumber;
    private String cvcNumber;
    private Client client;
}
