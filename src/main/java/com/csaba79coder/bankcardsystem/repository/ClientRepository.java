package com.csaba79coder.bankcardsystem.repository;

import com.csaba79coder.bankcardsystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
