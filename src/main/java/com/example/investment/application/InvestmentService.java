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
        investmentValidator.validateForCreate(investment);
        return investmentRepository.save(investment);
    }

    /**
     * @throws IllegalArgumentException si no existe una inversión con el id de {@code investment}
     */
    public Investment updateInvestment(Investment investment) {
        assertInvestmentExists(investment.getId());
        investmentValidator.validateForUpdate(investment);
        return investmentRepository.save(investment);
    }

    /**
     * @throws IllegalArgumentException si no existe una inversión con el id dado
     */
    public void deleteInvestment(String id) {
        assertInvestmentExists(id);
        investmentRepository.deleteById(id);
    }

    public List<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    private void assertInvestmentExists(String id) {
        if (!investmentRepository.existsById(id)) {
            throw new IllegalArgumentException("Inversión no encontrada.");
        }
    }
}
