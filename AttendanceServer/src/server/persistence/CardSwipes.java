package server.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CardSwipes")
@Table(name = "CardSwipes")
public class CardSwipes
{

  @Id
  @GeneratedValue
  @Column(name = "index_cardswipe")
  private long   indexCardSwipe;

  @Column(name = "CardNumber")
  private String cardNumber;

  @Column(name = "ClassRoom")
  private String classRoom;

  @Column(name = "SwipeTime")
  private Date   swipeTime;

  public CardSwipes()
  {

  }

  public long getSwipeID()
  {
    return indexCardSwipe;
  }

  public void setSwipeID(long indexCardSwipe)
  {
    this.indexCardSwipe = indexCardSwipe;
  }

  public String getCardNumber()
  {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

  public String getClassRoom()
  {
    return classRoom;
  }

  public void setClassRoom(String classRoom)
  {
    this.classRoom = classRoom;
  }

  public Date getSwipeTime()
  {
    return swipeTime;
  }

  public void setSwipeTime(Date swipeTime)
  {
    this.swipeTime = swipeTime;
  }

}
