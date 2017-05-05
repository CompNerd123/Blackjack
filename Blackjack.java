/**
 * BlackJack Instance
 * @author Chris M
 * @version 1.0
 */
import java.util.ArrayList;
/**
 * Class stub out for the beginning of a blackjack game.
 */
public class BlackJack {

    /**
     * Just a simple starting point for the class and it 
     * starts by playing a round.
     */
    public static void main(String [] strArgs) {
        BlackJack objGame = new BlackJack();
        objGame.playRound();
    }

    /**
     * Simple dealer logic to hard stop at 16.
     * @param objDealer Player Player you want to add cards to until they get over 16.
     * @param objDeck Deck Deak you want to get cards from.
     * @return Player Player instance with new cards added.
     */
    public Player dealerLogic(Player objDealer, Deck objDeck) {
        return dealerLogic(objDealer, objDeck, 16);
    }

    /**
     * Simple dealer logic to hard stop at a certain point.
     * @param objDealer Player Player you want to add cards to until they get over intStop.
     * @param objDeck Deck Deak you want to get cards from.
     * @param intStop int The total face value that stops the cards from being added.
     * @return Player Player instance with new cards added.
     */
    public Player dealerLogic(Player objDealer, Deck objDeck, int intStop) {
        while(objDealer.getTotalFaceValue() <= intStop &&
            objDealer.getNumberOfCards() < 4) {
            objDealer.addCard(objDeck.getCard());        
        }
        return objDealer;
    }

    /**
     * Incomplete concept of how you might play one round of blackjack.
     */
    public void playRound() {
        //TODO: Gut this logic and add your own function calls to play your own version of BlackJack.
    	int b1, b2, d1 = 0;
        Deck objDeck = new Deck();
        objDeck.shuffle();

        ArrayList<Player> aryPlayers = new ArrayList<Player>();
        aryPlayers.add(new Player());
        aryPlayers.add(new Player());
        b1 = aryPlayers.get(0).getMoney();
        b2 = aryPlayers.get(1).getMoney();
        aryPlayers.get(0).setMoney(b1);
        aryPlayers.get(1).setMoney(b2);
        Player objDealer = new Player("Dealer");
        
        objDealer.setMoney(objDealer.getMoney());
        aryPlayers.add(objDealer);

        while(b1 != 0 || b2 != 0){
       
        int intCurrentPlayer = 0;
        int intCounter = 0;
        
        while(intCounter < 2) {
            intCurrentPlayer = 0;
            while(intCurrentPlayer < aryPlayers.size()) {
                aryPlayers.get(intCurrentPlayer).addCard(objDeck.getCard());
                intCurrentPlayer++;
               
            }
            intCounter++;
        }

        intCurrentPlayer = 0;
        while(intCurrentPlayer < aryPlayers.size()) {
            if(aryPlayers.get(intCurrentPlayer).hasMoney()) {
            	/*if(intCurrentPlayer == 0){
            	//objDealer.inputBet();
                //System.out.println(objDealer);      
            	}*/
                aryPlayers.get(intCurrentPlayer).inputBet();    
            }
            intCurrentPlayer++;
        }

        this.dealerLogic(objDealer, objDeck);

        //System.out.println(aryPlayers);
        int player1 = aryPlayers.get(0).getTotalFaceValue();
        int player2 = aryPlayers.get(1).getTotalFaceValue();
        int dealer = objDealer.getTotalFaceValue();
        int f1 = 0,f2 = 0;
        
        if(player1 > player2 && player1 > dealer){
        	System.out.println("\nPlayer 1 wins this round\n");
        	f1 = 1;
        }else if(player2 > player1 && player2 > dealer){
        	System.out.println("\nPlayer 2 wins this round\n");
        	f2 = 2;
        }else if(dealer > player1 && dealer > player2){
        	System.out.println("\nDealer wins this round\n");
        }else if(dealer == player1){
        	System.out.println("\nPlayer 1 and dealer are tied\n");
        	//break;
        }else if(dealer == player2){
        	System.out.println("\nPlayer 2 and dealer are tied\n");
        	//break;
        }else if(player1 == player2){
        	System.out.println("\nPlayer 1 and Player2 are tied\n");
        	//break;
        }
        
        if(f1 == 1){
        	b1 = aryPlayers.get(0).getMoney() + aryPlayers.get(1).getBet();
        	d1 = objDealer.getMoney() - aryPlayers.get(0).getBet()
       			 + aryPlayers.get(1).getBet();
        }else if(f2 == 2){
        	b2 = aryPlayers.get(0).getMoney() + aryPlayers.get(0).getBet();
        	d1 = objDealer.getMoney() + aryPlayers.get(0).getBet()
       			 - aryPlayers.get(1).getBet();
        }else{
        	 b1 = aryPlayers.get(0).getMoney() - aryPlayers.get(0).getBet();
        	 b2 = aryPlayers.get(1).getMoney() - aryPlayers.get(1).getBet();
        	 d1 = objDealer.getMoney() + aryPlayers.get(0).getBet()
        			 + aryPlayers.get(1).getBet();
        }
        objDealer.setMoney(d1);
        System.out.println("\tDealer: \n\t\tTotal: $" + objDealer.getMoney());
        
        aryPlayers.get(0).setMoney(b1);
        System.out.println("\tPlayer 1: \n\t\tTotal: $" + aryPlayers.get(0).getMoney());
      
        aryPlayers.get(1).setMoney(b2);
        System.out.println("\tPlayer 2: \n\t\tTotal: $" + aryPlayers.get(1).getMoney());
        
        
        if(objDeck.shouldShuffle()) {
            objDeck.shuffle();
        }
        
        if(b1 == 6000){
        	System.out.println("\nPlayer 1 has all the money. Ending this round");
        	break;
        }else if(b2 == 6000){
        	System.out.println("\nPlayer 2 has all the money. Ending this round");
        	break;
        }else  if(d1 == 6000){
        	System.out.println("\nDealer has all the money. Ending this round");
        	break;
        }
        
        if(b1 == 0 && b2 == 0){
        	System.out.println("\nPlayer 1 and Player 2 have no money. Ending this round");
        	break;
        }else if(b1 == 0){
        	System.out.println("\nPlayer 1 has no money. Ending this round");
        	break;
        }else if(b2 == 0){
        	System.out.println("\nPlayer 2 has no money. Ending this round");
        	break;
        }
        
        //aryPlayers.get(0).clearHand();
       // aryPlayers.get(1).clearHand();
       // objDealer.clearHand();
    }

        /*
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.addCard(objDeck.getCard());
        objPlayer1.printHand();
        */
    }
}
