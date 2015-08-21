import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class GoFishTest {

  @Test
  public void goFish_initializesCorrectly_true() {
    GoFish testFish = new GoFish(3);

    assertEquals(true, testFish instanceof GoFish);
  }

  @Test
  public void goFish_initializesCorrectlyWithNumberOfPlayers_true() {
    GoFish testFish = new GoFish(3);

    assertEquals(3, testFish.getPlayers().size());
  }

  @Test
  public void goFish_dealsCards_true() {
    GoFish testFish = new GoFish(3);
    testFish.deal();
    ArrayList<Player> testPlayers = testFish.getPlayers();
    Player testPlayer = testPlayers.get(0);
    assertEquals(7, testPlayer.getHand().size());
  }

  @Test
  public void goFish_collectMatchesCollectsMatches_true() {
    GoFish testFish = new GoFish(2);
    testFish.deal();
    Card testCard = new Card("Hearts", "King");
    ArrayList<Player> testPlayers = testFish.getPlayers();
    Player testPlayer = testPlayers.get(0);
    testPlayer.addToHand(testCard);
    ArrayList<Card> kings = testFish.collectMatches("King", testPlayer);

    assertEquals(false, kings.size() == 0);
  }

  @Test
  public void goFish_goFishAddsCardFromDeckToHand_true() {
    GoFish testFish = new GoFish(2);
    ArrayList<Player> testPlayers = testFish.getPlayers();
    Player testPlayer = testPlayers.get(0);

    testFish.goFish(testPlayer);

    assertEquals(1, testPlayer.getHand().size());
  }

  @Test
  public void goFish_goFishTurn_true() {
    GoFish testFish = new GoFish(2);
    ArrayList<Player> testPlayers = testFish.getPlayers();
    Player testPlayer1 = testPlayers.get(0);
    Player testPlayer2 = testPlayers.get(1);

    Card testCard1 = new Card("Hearts", "Ace");
    Card testCard2 = new Card("Spades", "Ace");

    testPlayer2.addToHand(testCard1);
    testPlayer2.addToHand(testCard2);

    testFish.turn(testPlayer1,testPlayer2,"Ace");

    assertEquals(0, testPlayer2.getHand().size());
    assertEquals(2, testPlayer1.getHand().size()); //currently failing
  }

  @Test
  public void goFish_collectPairsCollectsAPair_true() {
    GoFish testFish = new GoFish(2);
    ArrayList<Player> testPlayers = testFish.getPlayers();
    testFish.deal();
    Player testPlayer1 = testPlayers.get(0);
    Player testPlayer2 = testPlayers.get(1);

    Card testCard1 = new Card("Hearts", "Ace");
    Card testCard2 = new Card("Clubs", "Ace");

    testPlayer2.addToHand(testCard1);
    testPlayer2.addToHand(testCard2);

    assertEquals(true, testFish.collectPairs(testPlayer2));
  }

  @Test
  public void goFish_getWinnerReturnsWinner_true() {
    GoFish testFish = new GoFish(2);
    ArrayList<Player> testPlayers = testFish.getPlayers();
    Player testPlayer1 = testPlayers.get(0);
    Player testPlayer2 = testPlayers.get(1);
    testPlayer1.addToScore(3);
    testPlayer2.addToScore(5);

    assertEquals(testPlayer2, testFish.getWinner());
  }

  @Test
  public void goFish_nextTurnChangesActivePlayer_true() {
    GoFish testFish = new GoFish(2);
    ArrayList<Player> testPlayers = testFish.getPlayers();
    Player testPlayer1 = testPlayers.get(0);
    Player testPlayer2 = testPlayers.get(1);
    testFish.nextTurn();

    assertEquals(testPlayer2, testFish.whoseTurn());
  }


}
