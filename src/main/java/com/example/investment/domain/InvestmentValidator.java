package com.example.investment.domain;

import com.example.investment.Investment;
import com.example.investment.infrastructure.InvestmentRepository;

import java.util.List;

public class InvestmentValidator {
    private final InvestmentRepository investmentRepository;

    public InvestmentValidator(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public void validate(Investment investment) {
        if (investment.getValue() <= 0) {
            throw new IllegalArgumentException("El valor de la inversión debe ser positivo.");
        }
        List<Investment> existingInvestments = investmentRepository.findByName(investment.getName());
        if (!existingInvestments.isEmpty()) {
            throw new IllegalArgumentException("Ya existe una inversión con el mismo nombre.");
        }
    }
}