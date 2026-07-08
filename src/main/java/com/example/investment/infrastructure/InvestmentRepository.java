package com.example.investment.infrastructure;

import com.example.investment.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, String> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, String id);
}
