package server.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Students
{

  @GeneratedValue
  @Column(name = "index_student")
  private long   indexStudent;

  @Column(name = "FirstName")
  private String firstName;

  @Column(name = "LastName")
  private String lastName;

  @Id
  @Column(name = "CardNumber")
  private String cardNumber;

  public Students()
  {

  }

  public long getStudentID()
  {
    return indexStudent;
  }

  public void setStudentID(long indexStudent)
  {
    this.indexStudent = indexStudent;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getCardNumber()
  {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber)
  {
    this.cardNumber = cardNumber;
  }

}
