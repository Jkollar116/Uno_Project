package com.mycompany.uno_project;
import java.util.*;

public class game{
    // Determines the order of the game based on an integer value.
    public static int order(int order) {
        if (order % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

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
    public static String wild() {
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        if (randomNum == 1) {
            return "RED";
        } else if (randomNum == 2) {
            return "BLUE";
        } else if (randomNum == 3) {
            return "GREEN";
        } else {
            return "YELLOW";
        }
    }

    // Generates a hand of cards.
    public static List<card> generateHand() {
        List<card> hand = new ArrayList<>();
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        for (int a = 0; a < 7 - randomNum; a++) {
            hand.add(numCard.generateRandomNumCard());
        }
        for (int i = 0; i < randomNum; i++) {
            hand.add(specialCard.generateRandomSpecialCard());
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
        } else {
            return false;
        }
    }
}
