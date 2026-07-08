package com.example.investment;

import com.example.investment.application.InvestmentService;
import com.example.investment.domain.InvestmentValidator;
import com.example.investment.infrastructure.InvestmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvestmentServiceTest {

    @Mock
    private InvestmentRepository investmentRepository;

    @Mock
    private InvestmentValidator investmentValidator;

    @InjectMocks
    private InvestmentService investmentService;

    @Test
    void addInvestmentValidatesAsCreateThenSaves() {
        Investment investment = new Investment("1", "Inversion 1", 1000.0, "2024-06-01", "Tipo 1");
        when(investmentRepository.save(investment)).thenReturn(investment);

        Investment result = investmentService.addInvestment(investment);

        assertNotNull(result);
        assertEquals(investment, result);
        verify(investmentValidator, times(1)).validateForCreate(investment);
        verify(investmentRepository, times(1)).save(investment);
    }

    @Test
    void updateInvestmentValidatesAsUpdateThenSaves() {
        Investment investment = new Investment("1", "Inversion 1", 1000.0, "2024-06-01", "Tipo 1");
        when(investmentRepository.existsById("1")).thenReturn(true);
        when(investmentRepository.save(investment)).thenReturn(investment);

        Investment result = investmentService.updateInvestment(investment);

        assertNotNull(result);
        assertEquals(investment, result);
        verify(investmentValidator, times(1)).validateForUpdate(investment);
        verify(investmentRepository, times(1)).save(investment);
    }

    @Test
    void updateInvestmentRejectsUnknownId() {
        Investment investment = new Investment("missing", "Inversion 1", 1000.0, "2024-06-01", "Tipo 1");
        when(investmentRepository.existsById("missing")).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> investmentService.updateInvestment(investment));
        verify(investmentRepository, never()).save(investment);
    }

    @Test
    void deleteInvestmentDeletesWhenIdExists() {
        when(investmentRepository.existsById("1")).thenReturn(true);

        investmentService.deleteInvestment("1");

        verify(investmentRepository, times(1)).deleteById("1");
    }

    @Test
    void deleteInvestmentRejectsUnknownId() {
        when(investmentRepository.existsById("missing")).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> investmentService.deleteInvestment("missing"));
        verify(investmentRepository, never()).deleteById("missing");
    }

    @Test
    void getAllInvestmentsReturnsRepositoryResult() {
        when(investmentRepository.findAll()).thenReturn(Collections.emptyList());

        List<Investment> result = investmentService.getAllInvestments();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(investmentRepository, times(1)).findAll();
    }
}
