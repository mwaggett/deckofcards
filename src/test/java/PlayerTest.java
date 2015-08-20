import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {

  @Test
  public void player_initializesCorrectly_true() {
    Player testPlayer = new Player("Bob");
    assertEquals(true, testPlayer instanceof Player);
  }

  @Test
  public void player_addToHandAddsCard_true() {
    Player testPlayer = new Player("Bob");
    Deck testDeck = new Deck();
    testPlayer.addToHand(testDeck.getTopCard());
    Card testCard = new Card("Spades","Ace");
    assertEquals(testCard.getName(), testPlayer.getHand().get(0).getName());
  }

  @Test
  public void player_removeCardRemovesCard_true() {
    Player testPlayer = new Player("Bob");
    Deck testDeck = new Deck();
    testPlayer.addToHand(testDeck.getTopCard());
    testDeck.removeTopCard();
    testPlayer.addToHand(testDeck.getTopCard());
    testDeck.removeTopCard();
    testPlayer.addToHand(testDeck.getTopCard());
    testDeck.removeTopCard();
    Card testCard = new Card("Spades","Ace");

    testPlayer.removeFromHand(testCard);
    assertEquals(2, testPlayer.getHand().size());
  }

}
