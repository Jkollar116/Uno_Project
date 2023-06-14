# Uno Project

This is a JavaFX implementation of the popular card game Uno. The project is built using the MVC (Model-View-Controller) design pattern.

## Getting Started

To run the project, follow these steps:

1. Clone the repository or download the source code.
2. Open the project in your preferred Java IDE.
3. Build the project and resolve any dependencies.
4. Run the `com.mycompany.uno_project.App` class to start the game.

## How to Play

The game follows the standard rules of Uno. The objective is to get rid of all your cards before the other players. Players take turns playing cards that match the color or value of the top card on the discard pile. If a player doesn't have a matching card, they must draw from the deck.

### Game Controls

- Use the numbered buttons to select a card from your hand.
- Click the "Draw" button to draw a card from the deck.
- Click the "Right Arrow" button to cycle the last card in your hand to the beginning.
- Click the "Left Arrow" button to cycle the first card in your hand to the end.
- Click on the "Wild Color" buttons to select a color for a wild card.
- The "Player Message" label displays the number of cards remaining in your hand.

### AI Players

The game includes AI players that follow the same rules as human players. They will automatically play their turns based on the current card and their available options.

## File Reader

The `com.mycompany.uno_project.fileReader` class is responsible for reading a file and extracting relevant information to initialize variables. It provides the following methods:

- `getColors()`: Returns an array of color names read from the file.
- `getSpecial()`: Returns an array of special card names read from the file.
- `getNumbers()`: Returns an array of number card names read from the file.
- `getNumberOfStartCards()`: Returns the number of start cards read from the file.
- `getNumberOfAiPlayers()`: Returns the number of AI players read from the file.
- `isAllSpecialCards()`: Returns a boolean indicating if all special cards are enabled as read from the file.

## Contributing

Contributions to this project are welcome. If you find any bugs or have suggestions for improvements, please open an issue or submit a pull request.
