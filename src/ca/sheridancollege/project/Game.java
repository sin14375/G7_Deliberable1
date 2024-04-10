package ca.sheridancollege.project;

//@author Group7_HarshdeepSingh

import java.util.Scanner;

public class Game 
{
    public static void main(String[] args) 
    {
        // Description of the game
        System.out.println("Welcome to GoFish Game!\nThis is a game of matching cards and suits with randomly generated packs.\n");
        
        System.out.println("Description:\nThe player need to enter their choice");
        
        System.out.println("Reference for entering the values:\nSuits: HEARTS(0), SPADES(1), DIAMONDS(2), CLUBS(3)"
                + "\nCards: ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), "
                + "JACK(11), QUEEN(12), KING(13)\n");

        Scanner inp = new Scanner(System.in);

        // Set up the player
        Player p1 = Player.setPlayer(inp);
        
        // Initialize player and computer scores
        int player_score = 0;
        int comp_score = 0;

        // Loop for the game rounds
        for (int i = 0; i < 4; i++) 
        {
            // Generate cards for the round
            Card[] InHand = GroupOfCards.generateCardsInHand(10);
               
            // Get player's guess
            Card guess = getPlayerGuess(inp);
            
            // Check if the guess matches any cards in the hand
            boolean win = checkGuess(InHand, guess);

            // Display result and update scores
            if (win) 
            {
                System.out.println(p1.getName() + " won");
                player_score += 1;
            } 
            else 
            {
                System.out.println(p1.getName() + " lost");
                comp_score += 1;
            }

            // Check if it's not the last round before asking to quit
            if (i < 3) 
            {
                // Check if the player wants to quit prematurely
                if (wantToQuit(inp)) 
                {
                    break;
                }
            }
            
            // Add space before starting the next round
            System.out.println();
        }

        // Display final scores
        displayFinalScores(player_score, comp_score, p1.getName());
    }
    
    // Method to get player's guess
    public static Card getPlayerGuess(Scanner inp) 
    {
        System.out.print("What is the suit of your guessed card: ");
        Card.Suit suit = getSuitInput(inp);
        
        System.out.print("What is the value of your card: ");
        Card.Value value = getValueInput(inp);
        
        return new Card(value, suit);
    }
    
    // Method to check if the guess matches any cards in the hand
    public static boolean checkGuess(Card[] hand, Card guess) 
    {
        for (Card c : hand) 
        {
            if (c.getSuit() == guess.getSuit() && c.getValue() == guess.getValue()) 
            {
                return true;
            }
        }
        return false;
    }
    
    // Method to get suit input from the player
    public static Card.Suit getSuitInput(Scanner inp) 
    {
        while (true) 
        {
            String suitInput = inp.nextLine();
            
            try 
            {
                int suitNum = Integer.parseInt(suitInput);
                if (suitNum >= 0 && suitNum <= 3) 
                {
                    return Card.Suit.values()[suitNum];
                } 
                else 
                {
                    throw new IllegalArgumentException(); // Input out of range
                }
            } 
            
            catch (NumberFormatException e)
            {
                try 
                {
                    // Try to parse input as suit name
                    return Card.Suit.valueOf(suitInput.toUpperCase());
                } 
                catch (IllegalArgumentException ex) 
                {
                    // Display message for invalid input
                    System.out.print("Invalid input! Please enter a valid suit: ");
                }
            } catch (IllegalArgumentException e) {
                // Display message for invalid input
                System.out.print("Invalid input! Please enter a valid suit: ");
            }
        }
    }
    
    // Method to get value input from the player
    public static Card.Value getValueInput(Scanner inp) 
    {
        while (true) 
        {
            String valInp = inp.nextLine().toUpperCase();
            
            try 
            {
                int valNum = Integer.parseInt(valInp);
                
                if (valNum >= 1 && valNum <= 13) 
                {
                    return Card.Value.values()[valNum - 1];
                } 
                else 
                {
                    throw new IllegalArgumentException(); // Input out of range
                }
            } 
            
            catch (NumberFormatException e) 
            { 
                try 
                {
                    // Try to parse input as card name
                    return Card.Value.valueOf(valInp);
                } 
                
                catch (IllegalArgumentException ex) 
                {
                    // Handle incorrect value input by converting to integer
                    System.out.print("Invalid input! Please enter a valid card: ");
                }
            } 
            
            catch (IllegalArgumentException e) 
            {
                // Display message for invalid input
                System.out.print("Invalid input! Please enter a valid card: ");
            }
        }
    }
    
    // Method to ask if the player wants to quit
    public static boolean wantToQuit(Scanner inp) 
    {
        System.out.print("Do you want to quit? (y/n): ");
        String quitInput = inp.nextLine().toLowerCase();
        return quitInput.equals("y");
    }
    
    // Method to display final scores and winner
    public static void displayFinalScores(int player_score, int comp_score, String playerName) 
    {
        System.out.println("Player Score: " + player_score);
        System.out.println("Computer Score: " + comp_score);
        System.out.println();
        
        if (player_score > comp_score) 
        {
            System.out.println(playerName + " won the game.");
            System.out.println("Thanks for playing!");
        } 
        else if (player_score < comp_score) 
        {
            System.out.println("Computer won the game.");
            System.out.println("Thanks for playing!");
        } 
        else 
        {
            System.out.println("It's a tie!");
            System.out.println("Thanks for playing!");
        }
    }
}
