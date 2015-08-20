import java.util.ArrayList;

public class Card {

  private String mSuit;
  private String mValue;

  public Card (String suit, String value){
    mSuit = suit;
    mValue = value;
  }

  public String getSuit() {
    return mSuit;
  }

  public String getValue() {
    return mValue;
  }

  public String getName() {
    return String.format("%s of %s", mValue, mSuit);
  }
}
