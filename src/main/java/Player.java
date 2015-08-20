import java.util.ArrayList;
import java.util.Collections;

class Player {

  private String mName;
  private ArrayList<Card> mHand;
  private int mScore;

  public Player(String name){
    mName = name;
    mHand = new ArrayList<Card>();
    mScore = 0;

  }

  public int getScore(){
    return mScore;
  }

  public void addToScore(int add){
    mScore = mScore + add;
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
