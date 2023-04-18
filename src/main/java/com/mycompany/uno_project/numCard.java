package com.mycompany.uno_project;

import java.util.*;
public class numCard extends card {
    static fileReader file = new fileReader();
    static final String[] COLORS = file.getColors();
    private static final String[] NUMBERS = file.getNumbers();

    // Constructor for the numCard class.
    public numCard(String number, String color) {
        super(color, number);
    }

    // Generates a random number card with a random color and number.
    public static numCard generateRandomNumCard() {
        Random rand = new Random();
        return new numCard(NUMBERS[rand.nextInt(NUMBERS.length)], COLORS[rand.nextInt(COLORS.length)]);
    }
}
