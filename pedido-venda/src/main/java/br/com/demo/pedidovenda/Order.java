package br.com.demo.pedidovenda;

public class Order {

    private double amount;
    private double discount;

    public void addItem(OrderedItem orderedItem) {
        amount += orderedItem.unitaryValue() * orderedItem.quantity();
    }

    public double getAmount() {
        return amount;
    }

    public double getDiscount() {
        return 0.0;
    }
}
