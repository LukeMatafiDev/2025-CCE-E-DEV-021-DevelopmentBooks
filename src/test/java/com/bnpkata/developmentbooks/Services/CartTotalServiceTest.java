package com.bnpkata.developmentbooks.Services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTotalServiceTest {

    private final CartTotalService service = new CartTotalService();

    @Test
    void testEmptyBasket() {
        assertEquals(0.0, service.calculatePrice(null));
    }

    @Test
    void oneBookCosts50NoDiscount() {
        double price = service.calculatePrice(List.of("Clean Code"));
        assertEquals(50.0, price);
    }

    @Test
    void twoDifferentBooksWith5PercentDiscount() {
        double price = service.calculatePrice(List.of("Clean Code", "The Clean Coder"));
        assertEquals(95.0, price);
    }

}
