package br.com.demo.pedidovenda;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<OrderedItem> orderedItems = new ArrayList<>();

    public void addItem(OrderedItem orderedItem) {
        orderedItems.add(orderedItem);
    }

    public OrderSummary summarize() {
        double totalValue = orderedItems.stream().mapToDouble(OrderedItem::getTotalValue).sum();
        double discount = 0;

        if (totalValue >= 1000) {
            discount = totalValue * 0.08;
        } else if (totalValue >= 800) {
            discount = totalValue * 0.06;
        } else if (totalValue >= 300) {
            discount = totalValue * 0.04;
        }

        return new OrderSummary(totalValue, discount);
    }
}
