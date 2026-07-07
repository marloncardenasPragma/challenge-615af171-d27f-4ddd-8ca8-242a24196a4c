package com.example.investment.infrastructure;

import com.example.investment.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, String> {
    List<Investment> findByName(String name);
}