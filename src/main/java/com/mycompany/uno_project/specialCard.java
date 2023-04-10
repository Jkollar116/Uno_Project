package com.mycompany.uno_project;

import java.util.Random;

public class specialCard extends card {
    private static final String[] COLORS = {"RED", "GREEN", "BLUE", "YELLOW"};
    private static final String[] SPECIAL = {"SKIP", "REVERSE", "DRAW TWO", "WILD", "WILD DRAW FOUR"};

    // Constructor for the specialCard class.
    public specialCard(String special, String color) {
        super(color, special);
        if (getValue().equals("WILD") || getValue().equals("WILD DRAW FOUR")) {
            setColor("BLACK");
        }
    }

    // Generates a random special card with a random color and special value.
    public static specialCard generateRandomSpecialCard() {
        Random rand = new Random();
        return new specialCard(SPECIAL[rand.nextInt(SPECIAL.length)], COLORS[rand.nextInt(COLORS.length)]);
    }
}
