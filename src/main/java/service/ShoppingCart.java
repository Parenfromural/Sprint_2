package service;

import model.Discountable;
import model.Food;

public class ShoppingCart {
    private Food[] products;

    public ShoppingCart(Food[] products) {
        this.products = products;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Food product : products) {
            totalPrice += product.getPrice() * product.getAmount();
        }
        return totalPrice;
    }

    public double getTotalPriceWithDiscount() {
        double totalPriceWithDiscount = 0;
        for (Food product : products) {
            double discount = 0;
            if (product instanceof Discountable) {
                discount = ((Discountable) product).getDiscount();
            }
            totalPriceWithDiscount += product.getPrice() * product.getAmount() * (1 - discount);
        }
        return totalPriceWithDiscount;
    }

    public double getTotalVegetarianPrice() {
        double totalVegetarianPrice = 0;
        for (Food product : products) {
            if (product.isVegetarian()) {
                totalVegetarianPrice += product.getPrice() * product.getAmount();
            }
        }
        return totalVegetarianPrice;
    }
}