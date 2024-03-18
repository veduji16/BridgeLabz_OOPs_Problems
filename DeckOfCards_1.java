package OOPs_Practice_Problems;

import java.util.Random;

public class DeckOfCards_1 {
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
        String[][] playerHands = new String[Num_Players][Cards_Per_Player];

        String[] deck = new String[Total_Cards];

        for (int i = 0; i < Total_Cards; i++) {
            deck[i] = RANKS[i % RANKS.length] + " of " + SUITS[i / RANKS.length];
        }

        shuffleDeck(deck);

        for (int player = 0; player < Num_Players; player++) {
            for (int card = 0; card < Cards_Per_Player; card++) {
                playerHands[player][card] = deck[player * Cards_Per_Player + card];
            }
        }

        for (int player = 0; player < Num_Players; player++) {
            System.out.println("Player " + (player + 1) + "'s hand.");
            for (int card = 0; card < Cards_Per_Player; card++) {
                System.out.println(playerHands[player][card]);
            }
            System.out.println();
        }
    }
}