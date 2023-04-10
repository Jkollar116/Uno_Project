package com.mycompany.uno_project;

import java.util.Random;

public class numCard extends card {
    static final String[] COLORS = {"RED", "GREEN", "BLUE", "YELLOW"};
    private static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

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
