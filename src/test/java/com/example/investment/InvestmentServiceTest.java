package com.example.investment;

import com.example.investment.application.InvestmentService;
import com.example.investment.domain.InvestmentValidator;
import com.example.investment.infrastructure.InvestmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class InvestmentServiceTest {

    @Mock
    private InvestmentRepository investmentRepository;

    @Mock
    private InvestmentValidator investmentValidator;

    @InjectMocks
    private InvestmentService investmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddInvestment() {
        Investment investment = new Investment("1", "Inversion 1", 1000.0, "2024-06-01", "Tipo 1");
        when(investmentRepository.save(investment)).thenReturn(investment);
        Investment result = investmentService.addInvestment(investment);
        assertNotNull(result);
        assertEquals(investment, result);
        verify(investmentRepository, times(1)).save(investment);
    }

    @Test
    void testUpdateInvestment() {
        Investment investment = new Investment("1", "Inversion 1", 1000.0, "2024-06-01", "Tipo 1");
        when(investmentRepository.save(investment)).thenReturn(investment);
        Investment result = investmentService.updateInvestment(investment);
        assertNotNull(result);
        assertEquals(investment, result);
        verify(investmentRepository, times(1)).save(investment);
    }

    @Test
    void testDeleteInvestment() {
        investmentService.deleteInvestment("1");
        verify(investmentRepository, times(1)).deleteById("1");
    }

    @Test
    void testGetAllInvestments() {
        when(investmentRepository.findAll()).thenReturn(Collections.emptyList());
        List<Investment> result = investmentService.getAllInvestments();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(investmentRepository, times(1)).findAll();
    }
}