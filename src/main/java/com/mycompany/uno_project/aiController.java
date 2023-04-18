package com.mycompany.uno_project;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        
    }

    @FXML
    private void wildColor2btn_Click(ActionEvent event) {
        applyWildCardColor(numCard.COLORS[1], player.size() - 1);
        
    }

    @FXML
    private void wildColor3btn_Click(ActionEvent event) {
        applyWildCardColor(numCard.COLORS[2], player.size() - 1);
        
    }

    @FXML
    private void wildColor4btn_Click(ActionEvent event) {
        applyWildCardColor(numCard.COLORS[3], player.size() - 1);
        
    }
    /**
     * The function moves the last card in the player's hand to the beginning of the hand and updates
     * the display.
     * 
     */
    @FXML
    private void rightArrowbtn_Click(ActionEvent event) {
        if (!player.isEmpty()) {
            card lastCard = player.remove(player.size() - 1);
            player.add(0, lastCard);
            updatePlayerHand();
        }
    }

   /**
    * This function moves the first card in the player's hand to the end of the hand.
    * 
    */
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
     */
    @FXML
    private void drawbtn_Click(ActionEvent event) throws IOException {
        player.add(game.generateRandomCard());
        updatePlayerHand();
        playOrder();
    }
    
    ArrayList<card> player = game.generateHand();
    // ArrayList<card> ai1 = game.generateHand();
    // ArrayList<card> ai2 = game.generateHand();
    card currentCard = game.generateRandomCard();
    card starterCard = game.generateRandomStartCard();
    int order = 2;
    ArrayList<ArrayList<card>> aiPlayers = new ArrayList<>();
        
    



/**
 * This function initializes the game board by assigning cards to buttons and displaying the number of
 * cards left for each player.
 * 
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
        
        drawbtn.setStyle("-fx-base: black;");
        showWildCardColors(false);
        //ArrayList<ArrayList<card>> aiPlayers = new ArrayList<>();
        for(int i = 0; i < game.getPlayers(); i++){
            aiPlayers.add(game.generateHand());
          
            }
        
            System.out.println("Number of AI players: " + aiPlayers.size());
            ai1txt.setText("AI1 " + aiPlayers.get(0).size() + " cards left");  
            ai2txt.setText("AI2 " + aiPlayers.get(1).size() + " cards left");  
        
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
 *  The function applies a wild card color to the current card and updates the player's hand, then calls
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
        System.out.println("Wild card color applied: " + color);
        updatePlayerHand();

        playOrder();
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
                });
                wildColor2btn.setOnAction(event -> {
                    applyWildCardColor(numCard.COLORS[1], index);
                });
                wildColor3btn.setOnAction(event -> {
                    applyWildCardColor(numCard.COLORS[2], index);
                });
                wildColor4btn.setOnAction(event -> {
                    applyWildCardColor(numCard.COLORS[3], index);
                    System.out.println("order: " + order);
                });
            } else {
                playOrder();
            }
        }
        

    }







 /**
  * This function represents the actions of an AI player in a card game.
  */
   public void aiPlayer(){
    int temp = 0;
    int numOrder = game.getPlayers(); //remember to fix this 
    System.out.println("numOrder: " + numOrder);
    // if(numOrder >= 1){
     for(int i = 0; i <  numOrder; i++){
        temp = 0;
        System.out.println("current card before ai "+ i + " played " + currentCard.getValue() + " " + currentCard.getColor()  + " and " + aiPlayers.get(i).size() + " cards left");
        ai1txt.setText("AI1 " + aiPlayers.get(0).size() + " cards left");
        ai2txt.setText("AI2 " + aiPlayers.get(1).size() + " cards left");

        if (currentCard.getValue().equals("DRAW TWO")) {
            System.out.println("card is draw two");
            aiPlayers.get(i).add(game.generateRandomCard());
            aiPlayers.get(i).add(game.generateRandomCard());
            currentCard.setValue("D");
            temp = 1;
       }
         else if (currentCard.getValue().equals("SKIP")) {
            System.out.println("card is skip");
              currentCard.setValue("S");
              temp = 1;
         }
         else if (currentCard.getValue().equals("REVERSE")) {
            System.out.println("card is reverse");
              currentCard.setValue("R");
              order = order + 1;
              temp = 1;
         }
         else if (currentCard.getValue().equals("WILD DRAW FOUR")) {
            System.out.println("card is wild draw four");
              aiPlayers.get(i).add(game.generateRandomCard());
              aiPlayers.get(i).add(game.generateRandomCard());
              aiPlayers.get(i).add(game.generateRandomCard());
              aiPlayers.get(i).add(game.generateRandomCard());
              currentCard.setValue("D");
              temp = 1;
         }
         else if (currentCard.getValue().equals("WILD")) {
            System.out.println("card is wild");
              currentCard.setValue("D");
              temp = 1;
         }
         else if (temp == 0) {
            for (int j = 0; j < aiPlayers.get(i).size(); j++) {
              if (game.isPlayable(aiPlayers.get(i).get(j), currentCard)) {
                   currentCard = aiPlayers.get(i).get(j);
                   assignCardToButton(aiPlayers.get(i).get(j), mainCardbtn);
                      aiPlayers.get(i).remove(j);
                      temp = 1;
                      if (currentCard.getValue().equals("WILD") || currentCard.getValue().equals("WILD DRAW FOUR")) {
                          currentCard.setColor(game.wild());
                          assignCardToButton(currentCard, mainCardbtn);
                          temp = 1;
                      }
                      break;
                   
              }
            }

     
        if (temp == 0) {
            aiPlayers.get(i).add(game.generateRandomCard());
        }
        if(aiPlayers.get(i).size() == 0){
            try {
                gameOverScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("current card after ai "+ i + " played " + currentCard.getValue() + " " + currentCard.getColor() + " and " + aiPlayers.get(i).size() + " cards left");
   }
   }
   if(currentCard.getValue().equalsIgnoreCase("skip")){
       playOrder();
   }
    if(currentCard.getValue().equalsIgnoreCase("reverse")){
         playOrder();
    }
    if(currentCard.getValue().equalsIgnoreCase("draw two")){
        player.addAll(game.drawTwo());
        updatePlayerHand();
        playOrder();
    }
    if(currentCard.getValue().equalsIgnoreCase("wild draw four")){
        player.addAll(game.drawFour());
        updatePlayerHand();
        playOrder();
    }
}



public void aiPlayerReverse(){
    int temp = 0;
    int numOrder = game.getPlayers();
    System.out.println("numOrder: " + numOrder);
    for(int i = 0;numOrder < i; i--){
        System.out.println(" gons twice current card before ai "+ i + " played " + currentCard.getValue() + " " + currentCard.getColor());
        if (currentCard.getValue().equals("DRAW TWO")) {
            aiPlayers.get(i).addAll(game.drawTwo());
            currentCard.setValue("D");
            temp = 1;
       }
         else if (currentCard.getValue().equals("SKIP")) {
             
              currentCard.setValue("S");
              temp = 1;
         }
         else if (currentCard.getValue().equals("REVERSE")) {
              currentCard.setValue("R");
              order = order + 1;
              temp = 1;
         }
         else if (currentCard.getValue().equals("WILD DRAW FOUR")) {
            aiPlayers.get(i).addAll(game.drawFour());
              currentCard.setValue("D");
              temp = 1;
         }
         else if (currentCard.getValue().equals("WILD")) {
              currentCard.setValue("D");
              temp = 1;
         }
         else if (temp == 0) {
            for (int j = 0; j < aiPlayers.get(i).size(); j++) {
              if (game.isPlayable(aiPlayers.get(i).get(j), currentCard) == true || currentCard.getValue().equals("R") || currentCard.getValue().equals("S") || currentCard.getValue().equals("D")) {
                   currentCard = aiPlayers.get(i).get(j);
                   assignCardToButton(aiPlayers.get(i).get(j), mainCardbtn);
                      aiPlayers.get(i).remove(j);
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
            aiPlayers.get(i).add(game.generateRandomCard());
        }
        if(aiPlayers.get(i).size() == 0){
            try {
                gameOverScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("gons twice current after before ai "+ i + " played " + currentCard.getValue() + " " + currentCard.getColor());
   }
    
       
   

    ai1txt.setText("AI1 " + aiPlayers.get(0).size() + " cards left");
    ai2txt.setText("AI2 " + aiPlayers.get(1).size() + " cards left");
    
   }








    // public void aiPlayer1() {
    //     int temp = 0;
    //     System.out.println("ai 1 cur card "+ currentCard.getValue());
    //     if (currentCard.getValue().equals("DRAW TWO")) {
    //         ai1.add(game.generateRandomCard());
    //         ai1.add(game.generateRandomCard());
    //         currentCard.setValue("D");
    //         ai1txt.setText("AI1 " + ai1.size() + " cards left");
    //         temp = 1;
    //     } else if (currentCard.getValue().equals("SKIP")) {
    //         System.out.println("");
    //         currentCard.setValue("S");
    //         temp = 1;
    //     } else if (currentCard.getValue().equals("REVERSE")) {
    //         currentCard.setValue("R");
    //         order = order + 1;
    //         temp = 1;
    //     } else if (currentCard.getValue().equals("WILD DRAW FOUR")) {
    //         ai1.add(game.generateRandomCard());
    //         ai1.add(game.generateRandomCard());
    //         ai1.add(game.generateRandomCard());
    //         ai1.add(game.generateRandomCard());
    //         currentCard.setValue("D");
    //         ai1txt.setText("AI1 " + ai1.size() + " cards left");
    //         temp = 1;
    //     } else if(temp == 0){
    //         for (int i = 0; i < ai1.size(); i++) {
    //             if (game.isPlayable(ai1.get(i), currentCard)== true || currentCard.getValue().equals("R") || currentCard.getValue().equals("S") || currentCard.getValue().equals("D")) {
    //                 currentCard = ai1.get(i);
    //                 assignCardToButton(ai1.get(i), mainCardbtn);
    //                 ai1.remove(i);
    //                 temp = 1;
    //                 if (currentCard.getValue().equals("WILD") || currentCard.getValue().equals("WILD DRAW FOUR")) {
    //                     currentCard.setColor(game.wild());
    //                     assignCardToButton(currentCard, mainCardbtn);
    //                     temp = 1;
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    //     if (temp == 0) {
    //         ai1.add(game.generateRandomCard());
    //     }
    //     ai1txt.setText("AI1 " + ai1.size() + " cards left");
    //     if (ai1.size() == 0) {
    //         try {
    //             gameOverScreen();
    //         } catch (IOException e) {
              
    //             e.printStackTrace();
    //         }
    //     }
    // }


 /**
  * This function represents the actions of an AI player in a card game, including playing cards,
  * drawing cards, and checking for game-ending conditions.
  */
    // public void aiPlayer2() {
    //     int temp = 0;
    //     System.out.println("ai 2 cur card "+ currentCard.getValue());
    //     if (currentCard.getValue().equals("DRAW TWO")) {
    //         ai2.add(game.generateRandomCard());
    //         ai2.add(game.generateRandomCard());
    //         currentCard.setValue("D");
    //         ai2txt.setText("AI2 " + ai2.size() + " cards left");
    //         temp = 1;
    //     } else if (currentCard.getValue().equals("SKIP")) {
    //         currentCard.setValue("S");
    //         temp = 1;
    //     } else if (currentCard.getValue().equals("REVERSE")) {
    //         currentCard.setValue("R");
    //         order = order + 1;
    //         temp = 1;
    //         currentCard.setValue("");
    //     } else if (currentCard.getValue().equals("WILD DRAW FOUR")) {
    //         ai2.add(game.generateRandomCard());
    //         ai2.add(game.generateRandomCard());
    //         ai2.add(game.generateRandomCard());
    //         ai2.add(game.generateRandomCard());
    //         temp = 1;
    //         currentCard.setValue("D");
    //         ai2txt.setText("AI2 " + ai2.size() + " cards left");
    //     }else if(temp == 0){
    //         for (int i = 0; i < ai2.size(); i++) {
    //             if (game.isPlayable(ai2.get(i), currentCard) == true || currentCard.getValue().equals("R") || currentCard.getValue().equals("S") || currentCard.getValue().equals("D")) {
    //                 currentCard = ai2.get(i);
    //                 assignCardToButton(ai2.get(i), mainCardbtn);
    //                 ai2.remove(i);
    //                 temp = 1;
    //                 if (currentCard.getValue().equals("WILD") || currentCard.getValue().equals("WILD DRAW FOUR")) {
    //                     currentCard.setColor(game.wild());
    //                     assignCardToButton(currentCard, mainCardbtn);
    //                     temp = 1;
    //                 }
    //                 break;
    //             }
    //         }
    //     }
    //     if (temp == 0) {
    //         ai2.add(game.generateRandomCard());
    //     }
    //     ai2txt.setText("AI2 " + ai2.size() + " cards left");
    //     if (ai2.size() == 0) {
    //         try {
    //             gameOverScreen();
    //         } catch (IOException e) {
                
    //             e.printStackTrace();
    //         }
    //     }
    // }
      
 /**
  * The function determines the order of play and calls either the aiPlayer or aiPlayerReverse function
  * based on the order.
  */
    public void playOrder() {
        System.out.println("order " + order);
        order = 2;
        if (game.order(order) == 2) {
            aiPlayer();
        } else {
            aiPlayerReverse();
        }
    }

   

    

    
/**
 * The function calculates the scores of each player in a card game and determines the winner based on
 * the total score.
 * 
 * @return The method is returning a String that states who won the game and their total score. If an
 * AI player has a score of 0, their name is included in the returned String. If no AI player has a
 * score of 0, the returned String congratulates the player for winning.
 */

    public String cardScore(){
int[] scores = new int[game.getPlayers()+1];
String str = "";
int count = 0;
for(int i = 0; i < aiPlayers.size(); i++){
    // count = aiPlayers.get(i).size();
    for(int j = 0; j < aiPlayers.get(i).size(); j++){
        System.out.println("ai player "+ i + " card: " +   aiPlayers.get(i).get(j).getValue());
        for(int k = 0; k <= 9;k++ ){
            str = Integer.toString(k);
            System.out.println("str: " + str);
            if(aiPlayers.get(i).get(j).getValue().equals(str)){
                scores[i] += k;
            }
        }
        if(aiPlayers.get(i).get(j).getValue().equals("SKIP")|| aiPlayers.get(i).get(j).getValue().equals("REVERSE")|| aiPlayers.get(i).get(j).getValue().equals("DRAW TWO")){
            scores[i] += 20;
        }
        if(aiPlayers.get(i).get(j).getValue().equals("WILD") || aiPlayers.get(i).get(j).getValue().equals("WILD DRAW FOUR")){
            scores[i] += 50;
        }
    System.out.println("ai player "+ i + " score: " +   scores[i]);
}
}
System.out.println("got to player score");
    for(int i = 0; i < player.size(); i++){
        for(int j = 0; j <= 9;j++ ){
            str = Integer.toString(j);
            if(player.get(i).getValue().equals(str)){
                scores[scores.length-1] += j;
            }
        }
        if(player.get(i).getValue().equals("SKIP")|| player.get(i).getValue().equals("REVERSE")|| player.get(i).getValue().equals("DRAW TWO")){
            scores[scores.length-1] += 20;
        }
        if(player.get(i).getValue().equals("WILD") || player.get(i).getValue().equals("WILD DRAW FOUR")){
            scores[scores.length-1] += 50;
        }
    }
System.out.println("player score is : " +scores[scores.length-1]);


    String personWhoWon = "";
    int total = 0;
    for(int i = 0; i < scores.length; i++){
        if(scores[i] == 0){
            personWhoWon = "AI" + (i+1);
        }
        total += scores[i];
    }

   if (personWhoWon.equals("")){
       personWhoWon = "Congratulations! You";
   }
        return personWhoWon + " won with " + total + " points";
    
    }
/**
 * The function writes the card scores to a file and sets the root to the end screen.
 */
    public void gameOverScreen() throws IOException{
        String cardScores = cardScore();
        System.out.println("cardscore is " + cardScores);
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
