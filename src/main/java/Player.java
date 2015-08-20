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

  public ArrayList<Card> getHand(){
    return mHand;
  }


}
