package ca.sheridancollege.project;

//@author Group7_HarshdeepSingh

import java.util.Random;

public class GroupOfCards 
{
    
    // Method to generate a set of cards in hand
    public static Card[] generateCardsInHand(int numOfCards) 
    {
        // Create an array to hold the cards
        Card[] InHand = new Card[numOfCards];
        
        // Generate cards randomly and add them to the array
        for(int i = 0; i < InHand.length; i++) 
        {
            // Generate a random value for the card
            Card.Value value = generateRandomValue();
            
            // Generate a random suit for the card
            Card.Suit suit = generateRandomSuit();
            
            // Create a new card with the generated value and suit
            Card card = new Card(value, suit);
            
            // Add the card to the array
            InHand[i] = card;
        } 
        
        // Return the array of cards
        return InHand;
    }
    
    // Method to generate a random card value
    private static Card.Value generateRandomValue() 
    {
        Random random = new Random();
        return Card.Value.values()[random.nextInt(Card.Value.values().length)];
    }
    
    // Method to generate a random card suit
    private static Card.Suit generateRandomSuit()
    {
        Random random = new Random();
        return Card.Suit.values()[random.nextInt(Card.Suit.values().length)];
    }
}
