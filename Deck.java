/**
 * Basic Deck class
 * @author Chris M
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Collections;
/**
 * Uses the card class to create a deck of cards.
 * @see Card
 */
public class Deck {

    private ArrayList<Card> aryDeck = new ArrayList<Card>();
    private int intCounterDeck = 0;

    /**
     * Default constructor that makes a deck of cards.
     */
    public Deck() {
        init();
    }

    /**
     * Constructor that makes pintCard number of decks of cards.
     * @param intDecks Number of decks to generate.
     */
    public Deck(int intDecks) {
        int intCounter = 0;
        while(intCounter < intDecks) {
            init();
            intCounter++;
        }
    }

    /**
     * Function used to add 52 cards to the arraylist for the deck.
     */
    private void init() {
        int intCounter = 1;
        while(intCounter <= 52) {
            aryDeck.add(new Card(intCounter));
            intCounter++;
        }
    }

    /**
     * Percent of the deck left. Used to determine if you need to shuffle the deck.
     * @return int The percent of the deck left.
     */
    public int percentLeft() {

        return ((this.intCounterDeck * 100) / aryDeck.size());
    }

    public boolean shouldShuffle() {
        int intShufflePercent = 75;
        int intCurrentPercent = percentLeft();
        //System.out.println("Deck %: " + intCurrentPercent);
        if(intCurrentPercent > intShufflePercent) {
            return true;
        }

        return false;
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        System.out.println("Shuffling...");
        Collections.shuffle(aryDeck);
        intCounterDeck = 0;
    }

    /**
     * Returns the next card off the top of the deck.
     * @return Card The top card off the deck.
     */
    public Card getCard() {
        return aryDeck.get(intCounterDeck++);
    }

    /**
     * Prints the entire deck and the percent left.
     * @return String 
     */
    public String toString() {
        return aryDeck.toString() + " - %" + percentLeft();
    }

    /**
     * Simple main showing the use of the deck class.
     */
    public static void main(String [] strArgs) {
        //Variables
        Deck objDeck = new Deck();
        int intTestNumberOfCards = 60;
        int intCurrentCard = 0;

        System.out.println(objDeck);

        while(intCurrentCard < intTestNumberOfCards) {
            if(objDeck.shouldShuffle()) {
                objDeck.shuffle();
                System.out.println(objDeck);
            }
            System.out.println(objDeck.getCard());
            intCurrentCard++;
        }
        
    }
}
