/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Game {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");

        boolean playAgain = true;

        while (playAgain) {
            Deck deck = new Deck();

            Dealer dealer = new Dealer();
            Player player = new Player("Player");

            // Reset from previous games
            dealer.resetHand();
            player.resetHand();

            // Initial deal: 2 cards to player, 1 to dealer (face up)
            player.getHand().addCard(deck.draw());
            player.getHand().addCard(deck.draw());
            dealer.getHand().addCard(deck.draw());
            dealer.getHand().addCard(deck.draw()); // Dealer's second card is face down

            // Player's turn
            while (true) {
                System.out.println("\nYour hand: " + player.getHand());
                System.out.println("Your score: " + player.getHand().calculateValue());
                System.out.println("Dealer's visible card: " + dealer.getHand().getCards().get(0));

                if (player.getHand().calculateValue() > 21) {
                    System.out.println("Bust! Dealer wins.");
                    break;
                }

                System.out.print("Do you want to (h)it or (s)tand? ");
                String decision = scanner.nextLine().toLowerCase();

                if (decision.equals("h")) {
                    player.getHand().addCard(deck.draw());
                } else if (decision.equals("s")) {
                    break;
                } else {
                    System.out.println("Invalid input, please type 'h' or 's'.");
                }
            }

            // Dealer's turn
            if (player.getHand().calculateValue() <= 21) {
                System.out.println("\nDealer's turn...");
                while (dealer.getHand().calculateValue() < 17) {
                    dealer.getHand().addCard(deck.draw());
                }
                System.out.println("Dealer's final hand: " + dealer.getHand());
                System.out.println("Dealer's score: " + dealer.getHand().calculateValue());
            }

            // Determine the winner
            if (player.getHand().calculateValue() > 21) {
                System.out.println("Dealer wins!");
            } else if (dealer.getHand().calculateValue() > 21 || 
                       player.getHand().calculateValue() > dealer.getHand().calculateValue()) {
                System.out.println("You win!");
            } else if (player.getHand().calculateValue() == dealer.getHand().calculateValue()) {
                System.out.println("It's a tie!");
            } else {
                System.out.println("Dealer wins!");
            }

            // Ask to play again
            System.out.print("\nPlay again? (y/n): ");
            playAgain = scanner.nextLine().toLowerCase().equals("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}//end class
