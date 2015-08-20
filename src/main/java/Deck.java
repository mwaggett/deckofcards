import java.util.ArrayList;
import java.util.Collections;

class Deck {
  private static final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
  private static final String[] VALUES = {
    "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
  };

  private ArrayList<Card> mCards;

  public Deck() {
    mCards = new ArrayList<Card>();
    for (String suit : SUITS) {
      for ( String value : VALUES){
        Card newCard = new Card(suit,value);
        mCards.add(newCard);
      }
    }
  }

  public Card getTopCard() {
    return mCards.get(0);
  }

  public void removeTopCard() {
    try {
      mCards.remove(0);
    } catch (IndexOutOfBoundsException e) {
    }
  }

  public void shuffle(){
    Collections.shuffle(mCards);
  }

  public void deal(Player player, int numberOfCards) {
    for (int i = 0; i < numberOfCards; i++) {
      player.addToHand(getTopCard());
      removeTopCard();
    }
  }

}
