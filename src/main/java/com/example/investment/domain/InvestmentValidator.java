package com.example.investment.domain;

import com.example.investment.Investment;
import com.example.investment.infrastructure.InvestmentRepository;
import org.springframework.stereotype.Component;

@Component
public class InvestmentValidator {
    private final InvestmentRepository investmentRepository;

    public InvestmentValidator(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    /**
     * Valida las reglas de negocio para crear una inversión: valor positivo y nombre no duplicado.
     *
     * @throws IllegalArgumentException si el valor no es positivo o el nombre ya está en uso
     */
    public void validateForCreate(Investment investment) {
        validateValue(investment);
        if (investmentRepository.existsByName(investment.getName())) {
            throw duplicateNameException();
        }
    }

    /**
     * Valida las reglas de negocio para actualizar una inversión: valor positivo y nombre no
     * duplicado, excluyendo a la propia inversión del chequeo de duplicados.
     *
     * @throws IllegalArgumentException si el valor no es positivo o el nombre ya está en uso
     */
    public void validateForUpdate(Investment investment) {
        validateValue(investment);
        if (investmentRepository.existsByNameAndIdNot(investment.getName(), investment.getId())) {
            throw duplicateNameException();
        }
    }

    private void validateValue(Investment investment) {
        if (investment.getValue() <= 0) {
            throw new IllegalArgumentException("El valor de la inversión debe ser positivo.");
        }
    }

    private static IllegalArgumentException duplicateNameException() {
        return new IllegalArgumentException("Ya existe una inversión con el mismo nombre.");
    }
}
