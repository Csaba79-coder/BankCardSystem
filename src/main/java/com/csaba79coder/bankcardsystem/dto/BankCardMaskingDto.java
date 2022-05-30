package com.csaba79coder.bankcardsystem.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankCardMaskingDto {

    private String maskedBankCardNumber;
    private String cvcNumber;
    private String nameOfOwner;
}
