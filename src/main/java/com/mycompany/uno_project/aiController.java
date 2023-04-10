package com.mycompany.uno_project;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class aiController extends game implements Initializable {

    // Declare FXML elements
    @FXML
    private Button card1btn;
    @FXML
    private Button card2btn;
    @FXML
    private Button card3btn;
    @FXML
    private Button card4btn;
    @FXML
    private Button card5btn;
    @FXML
    private Button card6btn;
    @FXML
    private Button card7btn;
    @FXML
    private Button mainCardbtn;
    @FXML
    private Button card8btn;
    @FXML
    private Button card9btn;
    @FXML
    private Button card10btn;
    @FXML
    private Button card11btn;
    @FXML
    private Label playerMessagetxt;
    @FXML
    private Button drawbtn;
    @FXML
    private Button rightArrowbtn;
    @FXML
    private Button leftArrowbtn;
    @FXML
    private Label ai1txt;
    @FXML
    private Label ai2txt;
    @FXML
    private Button wildColor1btn;
    @FXML
    private Button wildColor2btn;
    @FXML
    private Button wildColor3btn;
    @FXML
    private Button wildColor4btn;

    // Button action methods
    @FXML
    private void card1btn_Click(ActionEvent event) throws IOException {
        sendCard(0);
    }

    @FXML
    private void card2btn_Click(ActionEvent event) throws IOException {
        sendCard(1);
    }

    @FXML
    private void card3btn_Click(ActionEvent event) throws IOException {
        sendCard(2);
    }

    @FXML
    private void card4btn_Click(ActionEvent event) throws IOException {
        sendCard(3);
    }

    @FXML
    private void card5btn_Click(ActionEvent event) throws IOException {
        sendCard(4);
    }

    @FXML
    private void card6btn_Click(ActionEvent event) throws IOException {
        sendCard(5);
    }

    @FXML
    private void card7btn_Click(ActionEvent event) throws IOException {
        sendCard(6);
    }

    @FXML
    private void card8btn_Click(ActionEvent event) throws IOException {
        sendCard(7);
    }

    @FXML
    private void card9btn_Click(ActionEvent event) throws IOException {
        sendCard(8);
    }

    @FXML
    private void card10btn_Click(ActionEvent event) throws IOException {
        sendCard(9);
    }

    @FXML
    private void card11btn_Click(ActionEvent event) throws IOException {
        sendCard(10);
    }

    @FXML
    private void wildColor1btn_Click(ActionEvent event) {
        applyWildCardColor(numCard.COLORS[0], player.size() - 1);
        playOrder();
    }

    @FXML
    private void wildColor2btn_Click(ActionEvent event) {
        applyWildCardColor(numCard.COLORS[1], player.size() - 1);
        playOrder();
    }

    @FXML
    private void wildColor3btn_Click(ActionEvent event) {
        applyWildCardColor(numCard.COLORS[2], player.size() - 1);
        playOrder();
    }

    @FXML
    private void wildColor4btn_Click(ActionEvent event) {
        applyWildCardColor(numCard.COLORS[3], player.size() - 1);
        playOrder();
    }
    @FXML
    private void rightArrowbtn_Click(ActionEvent event) {
        if (!player.isEmpty()) {
            card lastCard = player.remove(player.size() - 1);
            player.add(0, lastCard);
            updatePlayerHand();
        }
    }

    @FXML
    private void leftArrowbtn_Click(ActionEvent event) {
        if (!player.isEmpty()) {
            card firstCard = player.remove(0);
            player.add(firstCard);
            updatePlayerHand();
        }
    }
    
    
    /**
     * The function adds a randomly generated card to the player's hand and calls either the aiPlayer
     * or aiPlayerReverse function based on the order returned by the game's order function.
     * 
     * @param event The event parameter is an object of the ActionEvent class, which represents the
     * event that occurred when the "drawbtn" button was clicked. It contains information about the
     * event, such as the source of the event and any additional data associated with it.
     */
    @FXML
    private void drawbtn_Click(ActionEvent event) throws IOException {
        player.add(game.generateRandomCard());
        updatePlayerHand();
        if (game.order(order) == 2) {
            aiPlayer();
        } else {
            aiPlayerReverse();
        }
    }
    
    List<card> player = game.generateHand();
    List<card> ai1 = game.generateHand();
    List<card> ai2 = game.generateHand();
    card currentCard = game.generateRandomCard();
    card starterCard = game.generateRandomStartCard();
    int order = 2;

/**
 * This function initializes the game board by assigning cards to buttons and displaying the number of
 * cards left for each player.
 * 
 * @param url The URL of the FXML file that contains the layout of the user interface.
 * @param rb ResourceBundle object that contains the resources for the current locale. It is used to
 * retrieve localized strings and other resources.
 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = game.generateHand();
        card startCard = starterCard;
        currentCard = startCard;
        assignCardToButton(player.get(0), card1btn);
        assignCardToButton(player.get(1), card2btn);
        assignCardToButton(player.get(2), card3btn);
        assignCardToButton(player.get(3), card4btn);
        assignCardToButton(player.get(4), card5btn);
        assignCardToButton(player.get(5), card6btn);
        assignCardToButton(player.get(6), card7btn);
        assignCardToButton(startCard, mainCardbtn);
        ai1txt.setText("AI1 " + ai1.size() + " cards left");  
        ai2txt.setText("AI2 " + ai2.size() + " cards left");  
        
        drawbtn.setStyle("-fx-base: black;");
        showWildCardColors(false);
    }

/**
 * This function updates the player's hand by assigning cards to buttons and displaying the number of
 * cards left.
 */
    private void updatePlayerHand() {
        int size = 0;
        Button[] buttons = {card1btn, card2btn, card3btn, card4btn, card5btn, card6btn, card7btn, card8btn, card9btn, card10btn, card11btn};
        if(player.size()+1 > buttons.length){
            size = buttons.length;
        }else {
            size = player.size();
        }for (int i = 0; i < size; i++) {
            assignCardToButton(player.get(i), buttons[i]);
        }for (int i = player.size(); i < buttons.length; i++) {
            buttons[i].setText("");
            buttons[i].setStyle("");
        }
        playerMessagetxt.setText(player.size() + " cards left");
    }

/**
 * This function assigns a card's value and color to a button in a Java GUI.
 * 
 * @param card The card object that contains information about the card's value and color.
 * @param button The button parameter is an instance of the JavaFX Button class. It is used to display
 * the value and color of a card.
 */
    private void assignCardToButton(card card, Button button) {
        String value = card.getValue();
        value = value.replace(" ", "\n");
        button.setText(value);
        button.setStyle("-fx-base: " + card.getColor().toLowerCase() + ";");
    }
/**
 * The function shows or hides four buttons representing different colors for a wild card.
 * 
 * @param show a boolean value that determines whether or not to show the wild card colors. If it is
 * true, the colors will be shown, and if it is false, the colors will be hidden.
 */
    private void showWildCardColors(boolean show) {
        wildColor1btn.setStyle("-fx-base: " + numCard.COLORS[0]  + ";");
        wildColor2btn.setStyle("-fx-base: " + numCard.COLORS[1]  + ";");
        wildColor3btn.setStyle("-fx-base: " + numCard.COLORS[2]  + ";");
        wildColor4btn.setStyle("-fx-base: " + numCard.COLORS[3]  + ";");
        wildColor1btn.setVisible(show);
        wildColor2btn.setVisible(show);
        wildColor3btn.setVisible(show);
        wildColor4btn.setVisible(show);
    }

/**
 * The function applies a wild card color to the current card and updates the player's hand, then calls
 * either the aiPlayer or aiPlayerReverse function depending on the game order.
 * 
 * @param color a String representing the color that the wild card will be changed to.
 * @param index The index parameter is an integer value that represents the index of the card in the
 * player's hand that the wild card color is being applied to.
 */
    private void applyWildCardColor(String color, int index) {
        currentCard.setColor(color);
        assignCardToButton(currentCard, mainCardbtn);
        showWildCardColors(false);
        System.out.println("index: " + index);
        System.out.println("player size: " + player.size());
        updatePlayerHand();
        System.out.println("game order: " + game.order(order));
        if (game.order(order) == 2) {
            aiPlayer();
        } else {
            aiPlayerReverse();
        }
    }
    
    
/**
 * The function sends a card from the player's hand to the game and updates the game state accordingly.
 * 
 * @param index The index parameter represents the index of the card that the player has clicked on in
 * their hand.
 */
    public void sendCard(int index) {
        System.out.println("Card clicked " + (index + 1));
        System.out.println("current card: " + currentCard.getValue() + " " + currentCard.getColor());
        System.out.println("clicked card: " + player.get(index).getValue() + " " + player.get(index).getColor());
        System.out.println("isPlayable result: " + game.isPlayable(player.get(index), currentCard));
        if (currentCard.getValue().equals("R")) {
            currentCard.setColor(player.get(index).getColor());
        } if (currentCard.getValue().equals("S")) {
            currentCard.setColor(player.get(index).getColor());
        } if (game.isPlayable(player.get(index), currentCard) == true) {
            currentCard = player.get(index);
            assignCardToButton(currentCard, mainCardbtn);
            if (player.size() == 1) {
                try {
                    gameOverScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                player.remove(index);
                updatePlayerHand();
             }  

            if (currentCard.getValue().equals("WILD") || currentCard.getValue().equals("WILD DRAW FOUR")) {
                showWildCardColors(true);
                wildColor1btn.setOnAction(event -> {
                    applyWildCardColor(numCard.COLORS[0], index);
                    playOrder();
                });
                wildColor2btn.setOnAction(event -> {
                    applyWildCardColor(numCard.COLORS[1], index);
                    playOrder();
                });
                wildColor3btn.setOnAction(event -> {
                    applyWildCardColor(numCard.COLORS[2], index);
                    playOrder();
                });
                wildColor4btn.setOnAction(event -> {
                    applyWildCardColor(numCard.COLORS[3], index);
                    playOrder();
                });
            } else {
                playOrder();
            }
        }
        

    }

 /**
  * This function represents the actions of an AI player in a card game.
  */
    public void aiPlayer1() {
        int temp = 0;
        System.out.println("ai 1 cur card "+ currentCard.getValue());
        if (currentCard.getValue().equals("DRAW TWO")) {
            ai1.add(game.generateRandomCard());
            ai1.add(game.generateRandomCard());
            currentCard.setValue("D");
            ai1txt.setText("AI1 " + ai1.size() + " cards left");
            temp = 1;
        } else if (currentCard.getValue().equals("SKIP")) {
            System.out.println("");
            currentCard.setValue("S");
            temp = 1;
        } else if (currentCard.getValue().equals("REVERSE")) {
            currentCard.setValue("R");
            order = order + 1;
            temp = 1;
        } else if (currentCard.getValue().equals("WILD DRAW FOUR")) {
            ai1.add(game.generateRandomCard());
            ai1.add(game.generateRandomCard());
            ai1.add(game.generateRandomCard());
            ai1.add(game.generateRandomCard());
            currentCard.setValue("D");
            ai1txt.setText("AI1 " + ai1.size() + " cards left");
            temp = 1;
        } else if(temp == 0){
            for (int i = 0; i < ai1.size(); i++) {
                if (game.isPlayable(ai1.get(i), currentCard)== true || currentCard.getValue().equals("R") || currentCard.getValue().equals("S") || currentCard.getValue().equals("D")) {
                    currentCard = ai1.get(i);
                    assignCardToButton(ai1.get(i), mainCardbtn);
                    ai1.remove(i);
                    temp = 1;
                    if (currentCard.getValue().equals("WILD") || currentCard.getValue().equals("WILD DRAW FOUR")) {
                        currentCard.setColor(game.wild());
                        assignCardToButton(currentCard, mainCardbtn);
                        temp = 1;
                    }
                    break;
                }
            }
        }
        if (temp == 0) {
            ai1.add(game.generateRandomCard());
        }
        ai1txt.setText("AI1 " + ai1.size() + " cards left");
        if (ai1.size() == 0) {
            try {
                gameOverScreen();
            } catch (IOException e) {
              
                e.printStackTrace();
            }
        }
    }


 /**
  * This function represents the actions of an AI player in a card game, including playing cards,
  * drawing cards, and checking for game-ending conditions.
  */
    public void aiPlayer2() {
        int temp = 0;
        System.out.println("ai 2 cur card "+ currentCard.getValue());
        if (currentCard.getValue().equals("DRAW TWO")) {
            ai2.add(game.generateRandomCard());
            ai2.add(game.generateRandomCard());
            currentCard.setValue("D");
            ai2txt.setText("AI2 " + ai2.size() + " cards left");
            temp = 1;
        } else if (currentCard.getValue().equals("SKIP")) {
            currentCard.setValue("S");
            temp = 1;
        } else if (currentCard.getValue().equals("REVERSE")) {
            currentCard.setValue("R");
            order = order + 1;
            temp = 1;
            currentCard.setValue("");
        } else if (currentCard.getValue().equals("WILD DRAW FOUR")) {
            ai2.add(game.generateRandomCard());
            ai2.add(game.generateRandomCard());
            ai2.add(game.generateRandomCard());
            ai2.add(game.generateRandomCard());
            temp = 1;
            currentCard.setValue("D");
            ai2txt.setText("AI2 " + ai2.size() + " cards left");
        }else if(temp == 0){
            for (int i = 0; i < ai2.size(); i++) {
                if (game.isPlayable(ai2.get(i), currentCard) == true || currentCard.getValue().equals("R") || currentCard.getValue().equals("S") || currentCard.getValue().equals("D")) {
                    currentCard = ai2.get(i);
                    assignCardToButton(ai2.get(i), mainCardbtn);
                    ai2.remove(i);
                    temp = 1;
                    if (currentCard.getValue().equals("WILD") || currentCard.getValue().equals("WILD DRAW FOUR")) {
                        currentCard.setColor(game.wild());
                        assignCardToButton(currentCard, mainCardbtn);
                        temp = 1;
                    }
                    break;
                }
            }
        }
        if (temp == 0) {
            ai2.add(game.generateRandomCard());
        }
        ai2txt.setText("AI2 " + ai2.size() + " cards left");
        if (ai2.size() == 0) {
            try {
                gameOverScreen();
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
    }
      
 /**
  * The function determines the order of play and calls either the aiPlayer or aiPlayerReverse function
  * based on the order.
  */
    public void playOrder() {
        if (game.order(order) == 2) {
            aiPlayer();
        } else {
            aiPlayerReverse();
        }
    }

    public void aiPlayer(){
        aiPlayer1();
        aiPlayer2();
}

    public void aiPlayerReverse(){
        aiPlayer2();
        aiPlayer1();
    }

    
// The above code is a Java method that calculates the score of each player in a card game and
// determines the winner. It takes the card values of each player and assigns points based on the value
// of the card. It then adds up the points for each player and determines the winner based on who has
// the lowest score. The method also writes the final score to a file and navigates to the end screen
// of the game.
    public String cardScore(){
        int ai1Count = 0;
        int ai2Count = 0;
        int playerCount = 0;
        for(int i = 0; i < ai1.size(); i++){
            if(ai1.get(i).getValue().equals("0") ){
                ai1Count = ai1Count + 0;
            } if(ai1.get(i).getValue().equals("1") ){
                ai1Count = ai1Count + 1;
            } if(ai1.get(i).getValue().equals("2") ){
                ai1Count = ai1Count + 2;
            } if(ai1.get(i).getValue().equals("3") ){
                ai1Count = ai1Count + 3;
            } if(ai1.get(i).getValue().equals("4") ){
                ai1Count = ai1Count + 4;
            } if(ai1.get(i).getValue().equals("5") ){
                ai1Count = ai1Count + 5;
            } if(ai1.get(i).getValue().equals("6") ){
                ai1Count = ai1Count + 6;
            } if(ai1.get(i).getValue().equals("7") ){
                ai1Count = ai1Count + 7;
            } if(ai1.get(i).getValue().equals("8") ){
                ai1Count = ai1Count + 8;
            } if(ai1.get(i).getValue().equals("9") ){
                ai1Count = ai1Count + 9;
            } if(ai1.get(i).getValue().equals("SKIP") ){
                ai1Count = ai1Count + 20;
            } if(ai1.get(i).getValue().equals("REVERSE") ){
                ai1Count = ai1Count + 20;
            } if(ai1.get(i).getValue().equals("DRAW TWO") ){
                ai1Count = ai1Count + 20;
            } if(ai1.get(i).getValue().equals("WILD") ){
                ai1Count = ai1Count + 50;
            } if(ai1.get(i).getValue().equals("WILD DRAW FOUR") ){
                ai1Count = ai1Count + 50;
            }
               }
        for(int i = 0; i < ai2.size(); i++){
           
            if(ai2.get(i).getValue().equals("0") ){
                ai2Count = ai2Count + 0;
            } if(ai2.get(i).getValue().equals("1") ){
                ai2Count = ai2Count + 1;
            } if(ai2.get(i).getValue().equals("2") ){
                ai2Count = ai2Count + 2;
            } if(ai2.get(i).getValue().equals("3") ){
                ai2Count = ai2Count + 3;
            } if(ai2.get(i).getValue().equals("4") ){
                ai2Count = ai2Count + 4;
            } if(ai2.get(i).getValue().equals("5") ){
                ai2Count = ai2Count + 5;
            } if(ai2.get(i).getValue().equals("6") ){
                ai2Count = ai2Count + 6;
            } if(ai2.get(i).getValue().equals("7") ){
                ai2Count = ai2Count + 7;
            } if(ai2.get(i).getValue().equals("8") ){
                ai2Count = ai2Count + 8;
            } if(ai2.get(i).getValue().equals("9") ){
                ai2Count = ai2Count + 9;
            } if(ai2.get(i).getValue().equals("SKIP") ){
                ai2Count = ai2Count + 20;
            } if(ai2.get(i).getValue().equals("REVERSE") ){
                ai2Count = ai2Count + 20;
            } if(ai2.get(i).getValue().equals("DRAW TWO") ){
                ai2Count = ai2Count + 20;
            } if(ai2.get(i).getValue().equals("WILD") ){
                ai2Count = ai2Count + 50;
            } if(ai2.get(i).getValue().equals("WILD DRAW FOUR") ){
                ai2Count = ai2Count + 50;
            }
        }
        for(int i = 0; i < player.size(); i++){
           
            if(player.get(i).getValue().equals("0") ){
                playerCount = playerCount + 0;
            } if(player.get(i).getValue().equals("1") ){
                playerCount = playerCount + 1;
            } if(player.get(i).getValue().equals("2") ){
                playerCount = playerCount + 2;
            } if(player.get(i).getValue().equals("3") ){
                playerCount = playerCount + 3;
            } if(player.get(i).getValue().equals("4") ){
                playerCount = playerCount + 4;
            } if(player.get(i).getValue().equals("5") ){
                playerCount = playerCount + 5;
            } if(player.get(i).getValue().equals("6") ){
                playerCount = playerCount + 6;
            } if(player.get(i).getValue().equals("7") ){
                playerCount = playerCount + 7;
            } if(player.get(i).getValue().equals("8") ){
                playerCount = playerCount + 8;
            } if(player.get(i).getValue().equals("9") ){
                playerCount = playerCount + 9;
            } if(player.get(i).getValue().equals("SKIP") ){
                playerCount = playerCount + 20;
            } if(player.get(i).getValue().equals("REVERSE") ){
                playerCount = playerCount + 20;
            } if(player.get(i).getValue().equals("DRAW TWO") ){
                playerCount = playerCount + 20;
            } if(player.get(i).getValue().equals("WILD") ){
                playerCount = playerCount + 50;
            } if(player.get(i).getValue().equals("WILD DRAW FOUR") ){
                playerCount = playerCount + 50;
            }
    }
   
    String personWhoWon = "";
    if(ai1Count == 0){
        personWhoWon = "AI1";
    }else if(ai2Count == 0){
        personWhoWon = "AI2";
    }else{
        personWhoWon = "Congratulations! You";    
    }
        System.out.println("AI1 has " + ai1Count + " points");
        System.out.println("AI2 has " + ai2Count + " points");
        System.out.println("Player has " + playerCount + " points");
        int total = ai1Count + ai2Count + playerCount;
        return personWhoWon + " won with " + total + " points";
    }
    
/**
 * The function writes the card scores to a file and sets the root to the end screen.
 */
    public void gameOverScreen() throws IOException{
        String cardScores = cardScore();
        try {
            FileWriter fileWriter = new FileWriter("cardScores.txt");
            fileWriter.write(cardScores);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        App.setRoot("endScreen");
    }


}
