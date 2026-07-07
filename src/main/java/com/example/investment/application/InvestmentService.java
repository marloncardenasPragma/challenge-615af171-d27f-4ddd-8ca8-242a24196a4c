package com.example.investment.application;

import com.example.investment.Investment;
import com.example.investment.domain.InvestmentValidator;
import com.example.investment.infrastructure.InvestmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {
    private final InvestmentRepository investmentRepository;
    private final InvestmentValidator investmentValidator;

    public InvestmentService(InvestmentRepository investmentRepository, InvestmentValidator investmentValidator) {
        this.investmentRepository = investmentRepository;
        this.investmentValidator = investmentValidator;
    }

    public Investment addInvestment(Investment investment) {
        investmentValidator.validate(investment);
        return investmentRepository.save(investment);
    }

    public Investment updateInvestment(Investment investment) {
        investmentValidator.validate(investment);
        return investmentRepository.save(investment);
    }

    public void deleteInvestment(String id) {
        investmentRepository.deleteById(id);
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }
}