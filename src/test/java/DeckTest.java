import org.junit.*;
import static org.junit.Assert.*;

public class DeckTest {

  @Test
  public void deck_initializesCorrectly_true() {
    Deck testDeck = new Deck();
    assertEquals(true, testDeck instanceof Deck);
  }

  @Test
  public void getTopCard_isAceOfSpades_true() {
    Deck testDeck = new Deck();
    Card expCard = new Card("Spades","Ace");
    assertEquals(expCard.getName(), testDeck.getTopCard().getName());
  }

  @Test
  public void getTopCard_isDifferentAfterShuffle_false() {
    Deck testDeck = new Deck();
    testDeck.shuffle();
    Card expCard = new Card("Spades","Ace");
    assertEquals(false, expCard.getName().equals(testDeck.getTopCard().getName()));
  }

  @Test
  public void getTopCard_isDifferentAfterRemoveTopCard_true() {
    Deck testDeck = new Deck();
    Card expCard = new Card("Spades","2");
    testDeck.removeTopCard();
    assertEquals(expCard.getName(), testDeck.getTopCard().getName());
  }

  @Test
  public void deal_dealsTwoCards_true() {
    Deck testDeck = new Deck();
    Player testPlayer = new Player("Bob");
    testDeck.deal(testPlayer,2);
    assertEquals(2, testPlayer.getHand().size());
  }
}
