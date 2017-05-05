/**
 * Basic Player class
 * @author Chris M
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Uses the card class to implement a player with a card hand, bet, and money.
 */
public class Player {

    static int intTotalNumberOfPlayers = 0;
    private ArrayList<Card> aryHand = new ArrayList<Card>();
    int intCurrentBet = 0;
    int intMoney = 2000;
    String strName = "no one";
    

    /**
     * Default constructor that adds players by number.
     */
    public Player() {
        name(++intTotalNumberOfPlayers);
    }

    /**
     * Constructor that sets the players name.
     */
    public Player(String pstrName) {
        name(pstrName);
    }

    /**
     * Sets the players name base on a number.
     * @param intPlayerNumber int The number of the player.
     */
    public void name(int intPlayerNumber) {
        name("Player " + intPlayerNumber);
    }

    /**
     * Sets the players name base on a string.
     * @param pstrName String The name of the player.
     */
    public void name(String pstrName) {
        strName = pstrName;
    }

    /**
     * Get the player name.
     * @return String The players name.
     */
    public String name() {
        return strName;
    }

    /**
     * Sets the money value for the player.
     * @param pintMoney int Money value to set for the player.
     */
    public void setMoney(int pintMoney) {
        intMoney = pintMoney;
    }

    /**
     * Get the current money the player has.
     * @return int Players current money.
     */
    public int getMoney() {
        return intMoney;
    }

    /**
     * Sets the current bet for the player.
     * @param intBet int The bet amount.
     */
    public void setBet(int intBet) {
        intCurrentBet = intBet; 
    }

    /**
     * Simple check to see if the player has money.
     * @return boolean True player has money, false otherwise.
     */
    public boolean hasMoney() {
        return (getMoney() > 0);
    }

    /**
     * Function to prompt user for the bet taking into consideration
     *  the amount of money they have.
     */ 
    public void inputBet() {
        double intBet = 0;
        setBet(0);
        Scanner objScanner = new Scanner(System.in);
   
       do {
            System.out.println(toString());
            System.out.print("Please enter your bet: ");
            intBet = objScanner.nextDouble();
            
           if((intBet) != (int)(intBet)){
            	System.out.println("\n" + name() +" you have entered a non-whole"
            			+ " number");
            }
           if(intBet < 1){
        	   System.out.println("\n" + name() +" you need to bet more"
           			+ " money");
           }
           
           if(intBet > getMoney()){
        	   System.out.println("\n" + name() +" you cannot bet more than $"
           			+ getMoney());
           }
           
        } while(intBet > getMoney() || (intBet < 1) || (intBet) != (int)(intBet));
        
        
        
        setBet((int)intBet);
    }

    /**
     * Gets the players current bet.
     * @return int The bet amount.
     */
    public int getBet() {
        return intCurrentBet;
    }

    /**
     * Calculates the total face value of the cards in the players hand.
     * @return int The total face value of the cards.
     */
    public int getTotalFaceValue() {
        int intFaceValueTotal = 0;
        int intCurrentCard = 0;
        Card objCard = null;
        boolean hasAce = false;
        while(intCurrentCard < aryHand.size()){
            objCard = aryHand.get(intCurrentCard);
            intFaceValueTotal += objCard.getFaceValue();
            if(objCard.getFace() == 1) {
                hasAce = true;
            }
            intCurrentCard++;
        }

        if(hasAce && intFaceValueTotal <= 11) {
            intFaceValueTotal += 10;
        }

        return intFaceValueTotal;
    }

    /**
     * Adds a card to the players hand.
     * @param objCard Card Card to add to players hand.
     */
    public void addCard(Card objCard) {
        aryHand.add(objCard);
    }

    /**
     * Clears the players current hand.
     */
    public void clearHand() {
        aryHand.clear();
    }

    /**
     * Prints out the current hand information.
     */
    public void printHand() {
        System.out.println(aryHand + " Total: " + getTotalFaceValue());
    }

    /**
     * Prints out the current player money information.
     */
    public void printMoney() {
        System.out.println("Total: $" + getMoney() + "\tBet: $" + getBet());
    }

    /**
     * Returns the number of cards in the players hand.
     * @return int The number of cards the player currently has.
     */
    public int getNumberOfCards() {
        return aryHand.size();
    }

    /**
     * Returns all the details about the player as a string.
     * @return String String containing all the player information.
     */
    public String toString() {
        return "\n" + name() + ": " + aryHand + " Total: " + getTotalFaceValue() + "\n" +
            "Total: $" + getMoney() + "\tBet: $" + getBet(); 
    }
}
