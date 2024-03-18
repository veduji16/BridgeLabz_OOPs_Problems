package OOPs_Practice_Problems;

import java.util.LinkedList;
import java.util.Random;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}

class Player {
    String name;
    LinkedList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }
}

public class DeckOfCards_2 {
    private static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades"
    };
    private static final String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King",
            "Ace" };
    private static final int Total_Cards = SUITS.length * RANKS.length;
    private static final int Num_Players = 4;
    private static final int Cards_Per_Player = 9;

    public static void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = 0; i < Total_Cards; i++) {
            int j = random.nextInt(Total_Cards);
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static void main(String[] args) {

        String[] deck = new String[Total_Cards];

        for (int i = 0; i < Total_Cards; i++) {
            deck[i] = RANKS[i % RANKS.length] + " of " + SUITS[i / RANKS.length];
        }

        shuffleDeck(deck);

        Player[] players = new Player[Num_Players];
        for (int i = 0; i < Num_Players; i++) {
            players[i] = new Player("Player " + (i + 1));
        }

        for (int i = 0; i < Num_Players * Cards_Per_Player; i++) {
            players[i % Num_Players].receiveCard(new Card(RANKS[i % RANKS.length], SUITS[i / RANKS.length]));
        }

        for (Player player : players) {
            System.out.println(player.name + "'s hand:");
            for (Card card : player.hand) {
                System.out.println(card.getRank() + " of " + card.getSuit());
            }
            System.out.println();
        }
    }
}