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
     * Valida las reglas de negocio de una inversión: valor positivo y nombre no duplicado.
     *
     * @param investment inversión a validar
     * @param excludeId  id a excluir del chequeo de duplicados; {@code null} al crear,
     *                   el propio id de la inversión al actualizar
     * @throws IllegalArgumentException si el valor no es positivo o el nombre ya está en uso
     */
    public void validate(Investment investment, String excludeId) {
        if (investment.getValue() <= 0) {
            throw new IllegalArgumentException("El valor de la inversión debe ser positivo.");
        }
        boolean nameTaken = excludeId == null
                ? investmentRepository.existsByName(investment.getName())
                : investmentRepository.existsByNameAndIdNot(investment.getName(), excludeId);
        if (nameTaken) {
            throw new IllegalArgumentException("Ya existe una inversión con el mismo nombre.");
        }
    }
}
