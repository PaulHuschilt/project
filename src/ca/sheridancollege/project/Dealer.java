/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author paulhuschilt
 */
public class Dealer {
    
    private Hand hand;

    public Dealer() {
        hand = new Hand();
    }

    public void takeCard(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }

    public void resetHand() {
        hand.clear();
    }

    public int showScore() {
        return hand.calculateValue();
    }
}
