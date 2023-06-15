package com.mycompany.uno_project;
import java.util.*;

public class game{
    static fileReader file = new fileReader();
    // Determines the order of the game based on an integer value.
  

    // Generates a random card, either a numCard or a specialCard.
    public static card generateRandomCard() {
        Random rand = new Random();
        int randomNum = rand.nextInt(2);
        if (randomNum == 0) {
            return numCard.generateRandomNumCard();
        } else {
            return specialCard.generateRandomSpecialCard();
        }
    }

    // Generates a random start card, which is always a numCard.
    public static card generateRandomStartCard() {
        return numCard.generateRandomNumCard();
    }

    // Generates a random wild color for the Ai.
   

    // Generates a hand of cards.
    public static ArrayList<card> generateHand() {
        ArrayList<card> hand = new ArrayList<>();
        Random rand = new Random();
        int start = fileReader.getNumberOfStartCards();
        double specialCardProbability = 0.3;
        System.out.println("start: " + start);
        for (int i = 0; i < start; i++) {
            double randomValue = rand.nextDouble();
            if (randomValue < specialCardProbability) {
                hand.add(specialCard.generateRandomSpecialCard());
            } else {
                hand.add(numCard.generateRandomNumCard());
            }
        }
    
        return hand;
    }
    

    // Determines if a card is playable based on the top card in the pile.
    public static boolean isPlayable(card card, card topCard) {
        if (card.getColor().toLowerCase().equals(topCard.getColor().toLowerCase()) || card.getValue().toLowerCase().equals(topCard.getValue().toLowerCase())) {
            return true;
        } else if (card.getValue().toLowerCase().equals("wild") || card.getValue().toLowerCase().equals("wild draw four")) {
            return true;
        } else if (topCard.getValue().toLowerCase().equals("wild") || topCard.getValue().toLowerCase().equals("wild draw four")) {
            return true;
        } else if (card.getValue().toLowerCase().equals("draw two") && topCard.getValue().toLowerCase().equals("d")) {
            return true;
        } else if (card.getValue().toLowerCase().equals("skip") && topCard.getValue().toLowerCase().equals("s")) {
            return true;
        } else if (card.getValue().toLowerCase().equals("reverse") && topCard.getValue().toLowerCase().equals("r")) {
            return true;
        } else if (card.getValue().toLowerCase().equals("wild draw four") && topCard.getValue().toLowerCase().equals("wd")) {
            return true;
        } else {
            return false;
        }
        
    }

    /**
     * This function returns the number of AI players from a file.
     * 
     * @return The method `getPlayers()` is returning an integer value which is obtained by calling the
     * `getNumberOfAiPlayers()` method of the `fileReader` class.
     */
    public static int getPlayers() {
        fileReader file = new fileReader();
        return file.getNumberOfAiPlayers();
    }


    /**
     * The function "drawTwo" generates and returns an ArrayList of two randomly generated cards.
     * 
     * @return An ArrayList of two randomly generated cards.
     */
    public static ArrayList<card> drawTwo() {
        ArrayList<card> drawTwo = new ArrayList<>();
        drawTwo.add(generateRandomCard());
        drawTwo.add(generateRandomCard());
        return drawTwo;

    }

    /**
     * The function "drawFour" returns an ArrayList of two randomly generated cards.
     * 
     * @return An ArrayList of four randomly generated cards.
     */
    public static ArrayList<card> drawFour() {
        ArrayList<card> drawTwo = new ArrayList<>();
        drawTwo.add(generateRandomCard());
        drawTwo.add(generateRandomCard());
        drawTwo.add(generateRandomCard());
        drawTwo.add(generateRandomCard());
        return drawTwo;

    }


    public static boolean isDrawTwo(String var) {
        if (var.toLowerCase().equals("draw two")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDrawFour(String var) {
        if (var.toLowerCase().equals("wild draw four")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSkip(String var) {
        if (var.toLowerCase().equals("skip")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isReverse(String var) {
        if (var.toLowerCase().equals("reverse")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isWild(String var) {
        if (var.toLowerCase().equals("wild")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isWildDrawFour(String var) {
        if (var.toLowerCase().equals("wild draw four")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getRandomColor() {
        Random rand = new Random();
        String[] COLORS = file.getColors();
        return COLORS[rand.nextInt(COLORS.length)];
    }



}

