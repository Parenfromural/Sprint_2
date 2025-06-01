package model;

import model.constants.Colour;

public class Apple extends Food implements Discountable {
    private String colour;

    public Apple(int amount, double price, String colour) {
        super(amount, price, true);
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public double getDiscount() {
        if (colour.equals(Colour.RED)) {
            return 0.6;
        }
        return 0;
    }
}