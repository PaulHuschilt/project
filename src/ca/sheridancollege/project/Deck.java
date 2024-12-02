/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author paulhuschilt
 */
public class Deck extends GroupOfCards {

    public Deck() {
        // Initialize the deck with the standard size of 52 cards
        super(52);
        cards = new ArrayList<>();
        
        // Populate the deck with cards
        Suit[] suits = Suit.values();
        Value[] values = Value.values();

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards.add(new Card(suits[i], values[j]));
            }
        }

        shuffle(); // Shuffle the deck after creation
    }

    /**
     * Draw a card from the top of the deck.
     * 
     * @return the card drawn.
     */
    public Card draw() {
        return cards.remove(0);
    }
}
