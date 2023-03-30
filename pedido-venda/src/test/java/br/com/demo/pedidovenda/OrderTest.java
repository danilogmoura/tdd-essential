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

    private void assertOrderSummary(double totalValue, double discount) {
        OrderSummary orderSummary = order.summarize();
        assertEquals(totalValue, orderSummary.getTotalValue(), 0.0001);
        assertEquals(discount, orderSummary.getDiscount(), 0.0001);
    }

    @Test
    void shouldPermitAddItem() {
        order.addItem(new OrderedItem("Soap", 3.0, 10));
    }

    @Test
    void shouldCalculateTotalValueAndDiscountForEmptyOrder() {
        double amount = 0.0;
        double discount = 0.0;

        assertOrderSummary(amount, discount);
    }

    @Test
    void shouldCalculateOrderSummaryForOneItemWithoutDiscount() {
        order.addItem(new OrderedItem("Soap", 5.0, 5));

        double amount = 25.0;
        double discount = 0.0;

        assertOrderSummary(amount, discount);
    }

    @Test
    void shouldCalculateOrderSummaryForTwoItemsWithoutDiscount() {
        order.addItem(new OrderedItem("Soap", 3.0, 3));
        order.addItem(new OrderedItem("Shampoo", 7.0, 3));

        double amount = 30.0;
        double discount = 0.0;

        assertOrderSummary(amount, discount);
    }

    @Test
    void shouldApplyDiscountInTheFirstRule() {
        order.addItem(new OrderedItem("Soap", 20.0, 20));

        double amount = 400.0;
        double discount = 16.0;

        assertOrderSummary(amount, discount);
    }

    @Test
    void shouldApplyDiscountInTheSecondRule() {
        order.addItem(new OrderedItem("Soap", 15.0, 30));
        order.addItem(new OrderedItem("Shampoo", 15.0, 30));

        double amount = 900.0;
        double discount = 54.0;

        assertOrderSummary(amount, discount);
    }

    @Test
    void shouldApplyDiscountInTheThirdRule() {
        order.addItem(new OrderedItem("Soap", 15.0, 30));
        order.addItem(new OrderedItem("Shampoo", 15.0, 30));
        order.addItem(new OrderedItem("Conditioner", 10.0, 30));

        double amount = 1200.0;
        double discount = 96.0;

        assertOrderSummary(amount, discount);
    }
}