/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author paulhuschilt
 */
public class Hand extends GroupOfCards {

    public Hand() {
        super(0);
        cards = new ArrayList<>();
    }

    /**
     * Add a card to the hand.
     * 
     * @param card the card to add.
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Calculate the total value of the hand.
     * 
     * @return the total value.
     */
    public int calculateValue() {
        int total = 0;
        int aces = 0;

        for (Card card : cards) {
            switch (card.getValue()) {
                case TWO: total += 2; break;
                case THREE: total += 3; break;
                case FOUR: total += 4; break;
                case FIVE: total += 5; break;
                case SIX: total += 6; break;
                case SEVEN: total += 7; break;
                case EIGHT: total += 8; break;
                case NINE: total += 9; break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING: total += 10; break;
                case ACE: 
                    total += 11;
                    aces++;
                    break;
            }
        }

        // Aces can either 1 or 11 
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }
    public void clear() {
        if (cards != null){
            cards.clear();

        }
    }
    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "No cards";
        }

        StringBuilder handString = new StringBuilder();
        for (Card card : cards) {
            handString.append(card.toString()).append(", ");
        }
        
        return handString.substring(0, handString.length() - 2);
    }
}
