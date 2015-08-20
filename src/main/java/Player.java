import java.util.ArrayList;
import java.util.Collections;

class Player {

  private String mName;
  private ArrayList<Card> mHand;

  public Player(String name){
    mName = name;
    mHand = new ArrayList<Card>();

  }

  public void addToHand(Card card){
    mHand.add(card);
  }

  public boolean findCard(Card card){
    return mHand.contains(card);
  }

  public void removeCard(Card card) {
    int count = 0;
    for (Card handCard : mHand) {
      if (handCard.getName().equals(card.getName())) {
        mHand.remove(count);
        break;
      }
      count ++;
    }
  }

  public ArrayList<Card> getHand(){
    return mHand;
  }


}
