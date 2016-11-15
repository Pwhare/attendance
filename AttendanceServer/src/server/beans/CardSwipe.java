package server.beans;

public class CardSwipe
{
  String cardNumber;
  String classRoom;

  public CardSwipe(String cardNumber, String classRoom)
  {
    super();
    this.cardNumber = cardNumber;
    this.classRoom = classRoom;
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

}
