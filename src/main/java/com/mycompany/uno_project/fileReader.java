package com.mycompany.uno_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class fileReader {
    private String[] colors;
    private String[] special;
    private String[] numbers;
    private int numberOfStartCards;
    private int numberOfAiPlayers;
    private boolean allSpecialCards;

    public fileReader() {
        String filePath = "C:\\Users\\Jkoll\\OneDrive - Farmingdale\\Documents\\NetBeansProjects\\Uno_Project\\src\\main\\resources\\com\\mycompany\\uno_project\\startFile.txt";
        readFile(filePath);
    }

    /**
     * This function reads a file and extracts relevant information from it to initialize variables 
     * 
     * @param filePath The file path of the file to be read.
     */
    private void readFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
    
                if (line.startsWith("Number Cards:")) {
                    String remaining = line.substring("Number Cards:".length());
                    String[] numberWords = remaining.split(",");
                    
                    numbers = new String[numberWords.length];
                    for (int i = 0; i < numberWords.length; i++) {
                        numbers[i] = wordToNumber(numberWords[i].strip());
                    }
                    
                } else if (line.startsWith("Special Cards:")) {
                    String remaining = line.substring("Special Cards:".length());
                    special = remaining.split(",");
                    
                    for (int i = 0; i < special.length; i++) {
                        special[i] = special[i].strip();
                    }
                    
                } else if (line.startsWith("Colors:")) {
                    String remaining = line.substring("Colors:".length());
                    colors = remaining.split(",");
                    
                    for (int i = 0; i < colors.length; i++) {
                        colors[i] = colors[i].strip();
                    }
                    
                } else if (line.startsWith("Number of Start Cards:")) {
                    String remaining = line.substring("Number of Start Cards:".length());
                    numberOfStartCards = Integer.parseInt(remaining.strip());
                    
                } else if (line.startsWith("Number of ai players:")) {
                    String remaining = line.substring("Number of ai players:".length());
                    numberOfAiPlayers = Integer.parseInt(remaining.strip());
    
                } else if (line.startsWith("#") || line.trim().isEmpty()) {
                    System.out.println("Comment line: " + line);

                } else if (line.startsWith("All Special Cards:")) {
                    String remaining = line.substring("All Special Cards:".length());
                    allSpecialCards = Boolean.parseBoolean(remaining.strip());
                    
                } else {
                    System.out.println("Unknown line: " + line);
                }
            }
    
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
    }
    

    /**
     * The function converts a word representation of a number to its corresponding numerical value in
     * string format.
     * 
     * @param word A string representing a word that corresponds to a number (e.g. "One", "Two",
     * "Three").
     * @return The method returns a String representation of a number corresponding to the input word.
     * If the input word matches one of the predefined words for numbers from zero to nine, the method
     * returns the corresponding digit as a String. If the input word does not match any of the
     * predefined words, the method returns the String "NUMBER NOT FOUND".
     */
    private String wordToNumber(String word) {
        if (word.equalsIgnoreCase("Zero")) {
            return "0";
        } else if (word.equalsIgnoreCase("One")) {
            return "1";
        } else if (word.equalsIgnoreCase("Two")) {
            return "2";
        } else if (word.equalsIgnoreCase("Three")) {
            return  "3";
        } else if (word.equalsIgnoreCase("Four")) {
            return  "4";
        } else if (word.equalsIgnoreCase("Five")) {
            return   "5";
        } else if (word.equalsIgnoreCase("Six")) {
            return "6";
        } else if (word.equalsIgnoreCase("Seven")) {
            return "7";
        } else if (word.equalsIgnoreCase("Eight")) {
            return "8";
        } else if (word.equalsIgnoreCase("Nine")) {
            return "9";
        } else {
           return "NUMBER NOT FOUND";
        }
    }

    public String[] getColors() {
        return colors;
    }

    public String[] getSpecial() {
        return special;
    }

    public int getNumberOfStartCards() {
        return numberOfStartCards;
    }

    public int getNumberOfAiPlayers() {
        return numberOfAiPlayers;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public boolean isAllSpecialCards() {
        return allSpecialCards;
    }

}
