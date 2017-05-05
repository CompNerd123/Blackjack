/**
 * Basic Card class
 * @author Chris M
 * @version 1.0
 */
import java.util.Random;

/**
 * The card class implements a basic playing card with a suite and face.
 */
public class Card {

    // Used in case of a card called without a constructor.
    private Random objRandom = new Random();
    // The internal value of the card.
    private int intCardValue = 0;

    /**
     * Default constructor that makes a card.
     */
    public Card()
    {
        this.intCardValue = objRandom.nextInt(52) + 1;
    }

    /**
     * Constructor that makes pintCard card.
     * @param pintCard Number of card 1 to 52 generate.
     */
    public Card(int pintCard)
    {
        if ((pintCard < 1) || (pintCard > 52)) {
            pintCard = 1;
            System.err.println("Card::Card - Invalid card value setting to 1.");
        }
        this.intCardValue = pintCard;
    }

    /**
     * Gets the face of the card 1-13.
     * @return The face of the card 1-13.
     */
    public int getFace() {
        return ((intCardValue - 1) % 13) + 1;
    }

    /**
     * Gets the value of the card 1 to 10.
     * @return The value of the card 1-10.
     */
    public int getFaceValue() {
        int intFaceValue = getFace();
        
        //Face value of card
        if(intFaceValue > 10) {
            intFaceValue = 10;
        }

        return intFaceValue;
    }

    /**
     * Returns the string value for the face of the card.
     * @return The string value for the face of the card.
     */
    public String getFaceString() {
        String strReturn = "";
        int intFace = this.getFace();
        switch(intFace)
        {
            case 1:
                strReturn += "Ace";
                break;
            case 11:
                strReturn += "Jack";
                break;
            case 12:
                strReturn += "Queen";
                break;
            case 13:
                strReturn += "King";
                break;
            default:
                strReturn += intFace;
        }

        return strReturn;
    }

    /**
     * Returns the value of the card suite.
     * @return The value of the card suite.
     */
    public int getSuite() {
        return (intCardValue - 1) / 13;
    }

    /**
     * Returns a string representing the suite of the card.
     * @return The suite of the card as a string.
     */
    public String getSuiteString() {
        String strReturn = "";
        int intSuite = this.getSuite();
        if(intSuite == 0) {
            strReturn += "Club";
        } else if (intSuite == 1) {
            strReturn += "Diamonds";
        } else if (intSuite == 2) {
            strReturn += "Hearts";
        } else if (intSuite == 3) {
            strReturn += "Spades";
        }
        return strReturn;
    }

    /**
     * The card represented as a string.
     * @return The full string description of the card.
     */
    public String toString() {
        String strReturn = "";
        strReturn += this.getFaceString();
        strReturn += " of ";
        strReturn += this.getSuiteString();
        return strReturn;
    }

    /**
     * Sample main showing how to create a card.
     */
    public static void main(String [] strArgs) {
        //Variables
        Card objCard = new Card();
        System.out.println(objCard);
    }

}
