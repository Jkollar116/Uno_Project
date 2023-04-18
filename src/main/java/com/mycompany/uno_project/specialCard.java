package com.mycompany.uno_project;

import java.util.ArrayList;
import java.util.Random;

public class specialCard extends card {
   
    
    private static final fileReader fileReader = new fileReader();
    private static final String[] COLORS = fileReader.getColors();
    private static final String[] SPECIAL = fileReader.getSpecial();
    // private static final String[] COLORS = {"RED", "BLUE", "GREEN", "YELLOW"};
    // private static final String[] SPECIAL = {"WILD", "WILD DRAW FOUR", "SKIP", "REVERSE", "DRAW TWO"};


    // Constructor for the specialCard class.
    public specialCard(String special, String color) {
        super(color, special);
        if (getValue().equalsIgnoreCase("WILD") || getValue().equalsIgnoreCase("WILD DRAW FOUR")) {
            setColor("BLACK");
        }
    }

    // Generates a random special card with a random color and special value.
    public static specialCard generateRandomSpecialCard() {
        Random rand = new Random();
        return new specialCard(SPECIAL[rand.nextInt(SPECIAL.length)], COLORS[rand.nextInt(COLORS.length)]);
    }
}
