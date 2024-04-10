package ca.sheridancollege.project;

//@author Group7_HarshdeepSingh

public class Card 
{
    // Enum representing the suits of the cards
    public enum Suit { HEARTS, SPADES, DIAMONDS, CLUBS };
    
    // Enum representing the values of the cards
    public enum Value { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING };
    
    // Private fields for card value and suit
    private Value value;
    private Suit suit;

    // Constructor for Card class
    public Card(Value value, Suit suit) 
    {
        this.value = value;
        this.suit = suit;
    }

    // Getter method for card value
    public Value getValue() 
    {
        return value;
    }

    // Setter method for card value
    public void setValue(Value value) 
    {
        this.value = value;
    }

    // Getter method for card suit
    public Suit getSuit() 
    {
        return suit;
    }

    // Setter method for card suit
    public void setSuit(Suit suit) 
    {
        this.suit = suit;
    }

    // Method to create a new card instance
    public static Card createCard(Value value, Suit suit) 
    {
        return new Card(value, suit);
    }

    // Method to convert string input to card value
    public static Value parseValue(String valueStr) throws IllegalArgumentException 
    {
        return Value.valueOf(valueStr.toUpperCase());
    }

    // Method to convert string input to card suit
    public static Suit parseSuit(String suitStr) throws IllegalArgumentException 
    {
        return Suit.valueOf(suitStr.toUpperCase());
    }
}
