package com.csaba79coder.bankcardsystem.repository;

import com.csaba79coder.bankcardsystem.model.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
}
