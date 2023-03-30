package br.com.demo.pedidovenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    Order order;

    @BeforeEach
    void setup() {
        order = new Order();
    }

    private void assertOrderSummary(double amount, double discount) {
        assertEquals(amount, order.getAmount(), 0.0001);
        assertEquals(discount, order.getDiscount(), 0.0001);
    }

    @Test
    void shouldPermitAddItem() {
        order.addItem(new OrderedItem("Sabonete", 3.0, 10));
    }

    @Test
    void shouldCalculateTotalValueAndDiscountForEmptyOrder() {
        double amount = 0.0;
        double discount = 0.0;

        assertOrderSummary(amount, discount);
    }

    @Test
    void shouldCalculateOrderSummaryForOneItemWithoutDiscount() {
        order.addItem(new OrderedItem("Sabonete", 5.0, 5));

        double amount = 25.0;
        double discount = 0.0;

        assertOrderSummary(amount, discount);
    }
}