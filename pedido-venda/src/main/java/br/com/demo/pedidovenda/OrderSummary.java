package br.com.demo.pedidovenda;

public class OrderSummary {
    private final double totalValue;
    private final double discount;

    public OrderSummary(double totalValue, double discount) {
        this.totalValue = totalValue;
        this.discount = discount;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public double getDiscount() {
        return discount;
    }
}
