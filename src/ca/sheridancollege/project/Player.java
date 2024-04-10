package ca.sheridancollege.project;

//@author Group7_HarshdeepSingh

import java.util.Scanner;

public class Player 
{
    private String name;

    // Getter method for player name
    public String getName() 
    {
        return name;
    }

    // Setter method for player name
    public void setName(String name) 
    {
        this.name = name;
    }

    // Method to set player's name
    public static Player setPlayer(Scanner inp) 
    {
        // Prompt the user to enter player's name
        System.out.print("Enter the player's name: ");
        String name = inp.nextLine();
        System.out.println("");
        
        // Create a new Player object
        Player player = new Player();
        
        // Set the player's name
        player.setName(name);
        
        // Return the Player object
        return player;
    }
}
