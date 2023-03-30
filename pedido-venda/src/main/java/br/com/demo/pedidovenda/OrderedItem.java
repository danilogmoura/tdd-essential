package br.com.demo.pedidovenda;

import java.util.Objects;

public final class OrderedItem {

    private final String description;
    private final double unitaryValue;
    private final int quantity;

    public OrderedItem(String description, double unitaryValue, int quantity) {
        this.description = description;
        this.unitaryValue = unitaryValue;
        this.quantity = quantity;
    }

    public String description() {
        return description;
    }

    public double unitaryValue() {
        return unitaryValue;
    }

    public int quantity() {
        return quantity;
    }

    public double getTotalValue() {
        return unitaryValue * quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (OrderedItem) obj;
        return Objects.equals(this.description, that.description) &&
                Double.doubleToLongBits(this.unitaryValue) == Double.doubleToLongBits(that.unitaryValue) &&
                this.quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, unitaryValue, quantity);
    }

    @Override
    public String toString() {
        return "ItemPedido[" +
                "description=" + description + ", " +
                "unitaryValue=" + unitaryValue + ", " +
                "quantity=" + quantity + ']';
    }


}