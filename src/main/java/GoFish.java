import java.util.ArrayList;
import java.io.Console;

public class GoFish {

  private int mNumberOfPlayers;
  private ArrayList<Player> mPlayers;
  private Deck mDeck;
  private int mTurn = 0;
  private Player mActivePlayer;

  public GoFish(int numberOfPlayers) {
    mPlayers = new ArrayList<Player>();
    mNumberOfPlayers = numberOfPlayers;
    for (int i=1; i<=numberOfPlayers; i++) {
      Player newPlayer = new Player("Player "+i);
      mPlayers.add(newPlayer);
    }
    mDeck = new Deck();
    mDeck.shuffle();
    mActivePlayer = mPlayers.get(mTurn);
  }

  public void play(){
    deal();
    while(!mDeck.isEmpty()){
      Console myConsole = System.console();
      System.out.printf("%s's turn. %n",mActivePlayer.getName());
      String hand = mActivePlayer.displayHand();
      System.out.printf("Here is your hand: %s %n", hand);
      System.out.printf("Ask who? %n");
      int askedInt = Integer.parseInt(myConsole.readLine());
      Player askedPlayer = mPlayers.get(askedInt);

      System.out.printf("Ask for what? %n");
      String value = myConsole.readLine();

      turn(mActivePlayer,askedPlayer,value);
    }
    System.out.printf("%s wins!", getWinner().getName());

  }

  public void nextTurn(){
    mTurn = (mTurn + 1) % mPlayers.size();
    mActivePlayer = mPlayers.get(mTurn);
  }

  public ArrayList<Player> getPlayers(){
    return mPlayers;
  }

  public Player whoseTurn() {
    return mActivePlayer;
  }

  public void deal() {
    for (Player player : mPlayers) {
      mDeck.deal(player, 7);
    }
  }

  public ArrayList<Card> collectMatches(String value, Player player){
    ArrayList<Card> playerHand = player.getHand();
    ArrayList<Card> matchCards = new ArrayList<Card>();
    for(Card card : playerHand){
      if (card.getValue().equals(value)){
        matchCards.add(card);
      }
    }
    return matchCards;
  }

  public void goFish(Player player){
    player.addToHand(mDeck.getTopCard());
    mDeck.removeTopCard();
  }

  public boolean collectPairs(Player player){
    ArrayList<Card> hand = player.getHand();
    int originalScore = player.getScore();
    for(int i = 0; i < hand.size(); i++){
      Card cardI = hand.get(i);
      for(int j = 0; j < hand.size(); j++){
        Card cardJ = hand.get(j);
        if (cardI.getValue().equals(cardJ.getValue()) && i != j){
          player.removeCard(cardI);
          player.removeCard(cardJ);
          player.addToScore(1);
        }
      }
    }
    return (player.getScore() > originalScore);
  }


  public void turn(Player current, Player asked, String value){
    ArrayList<Card> matchCards = collectMatches(value, asked);
    if (matchCards.size() == 0) {
      System.out.println("Go fish!");
      goFish(current);
    } else {
      for (Card card : matchCards){
        asked.removeCard(card);
        current.addToHand(card);
      }
    }
    collectPairs(current);
    nextTurn();
  }
  //^^Not passing test for adding to hand.

  public Player getWinner() {
    Player winner = mPlayers.get(0);
    for (Player player : mPlayers) {
      if (player.getScore() > winner.getScore()) {
        winner = player;
      }
    }
    return winner;
  }
}
