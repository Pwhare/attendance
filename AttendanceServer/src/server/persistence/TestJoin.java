package server.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * The idea here is this is a basic CardSwipes SELECT, 
 * joined with the Students to provide First and Last Name
 */

@Entity(name = "TestJoins")
@Table(name = "CardSwipes")
public class TestJoin
{
  @Id
  @GeneratedValue
  @Column(name = "index_cardswipe")
  private long     indexCardSwipe;

  // @Column(name = "CardNumber")
  // private String cardnumber;

  @Column(name = "ClassRoom")
  private String   classRoom;

  @Column(name = "SwipeTime")
  private Date     swipeTime;

  @ManyToOne
  @JoinColumn(name = "CardNumber")
  private Students student;

  public TestJoin()
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

  // public String getCardNumber()
  // {
  // return cardnumber;
  // }
  //
  // public void setCardNumber(String cardNumber)
  // {
  // this.cardnumber = cardNumber;
  // }

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

  public Students getStudent()
  {
    return student;
  }

  public void setStudent(Students student)
  {
    this.student = student;
  }

}