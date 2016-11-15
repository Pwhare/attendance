package server.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import server.controller.GetStudents;
import server.controller.GetSwipes;
import server.persistence.CardSwipes;
import server.persistence.Students;
import server.persistence.TestJoin;

public class WhenTestingServerReads
{
  private static Logger logger = Logger.getLogger(WhenTestingServerReads.class);

  @Test
  public void shouldRetrieveCardSwipes()
  {
    logger.info("About to shouldRetrieveCardSwipes");
    GetSwipes gs = new GetSwipes();
    List<TestJoin> testjoins = new ArrayList<TestJoin>();

    testjoins = gs.getAllCardSwipes();

    logger.info("Size: " + testjoins.size() + " Number(1) " + testjoins.get(0).getStudent().getCardNumber().toString());

    for (TestJoin testjoin : testjoins)
    {
      // String fn = testjoin.getStudent().getFirstName();
      logger.info("[][]> " + testjoin.getStudent().getCardNumber().toString() + " Name: "
          + testjoin.getStudent().getFirstName() + " Last: " + testjoin.getStudent().getLastName());
    }
  }

  // @Test
  public void shouldRetrieveCardSwipesSQL()
  {
    logger.info("About to shouldRetrieveCardSwipesSQL");
    GetSwipes gs = new GetSwipes();
    // List<CardSwipes> cardswipes = new ArrayList<CardSwipes>();

    List cardswipes = gs.getSQLCardSwipes();

    logger.info("Size: " + cardswipes.size());
    // logger.info("Size: " + cardswipes.size() + " Number(1) " +
    // cardswipes.get(0).getCardNumber().toString());

    for (Iterator iterator = cardswipes.iterator(); iterator.hasNext();)
    {
      CardSwipes cardswipe = (CardSwipes) iterator.next();
      logger.info("[][]> " + cardswipe.getCardNumber());
    }
  }

  // @Test
  public void shouldRetrieveStudents()
  {
    logger.info("About to shouldRetrieveStudents");
    GetStudents gs = new GetStudents();
    List<Students> students = gs.getAllStudents();

    for (Students student : students)
    {
      logger.info("Firstname: " + student.getFirstName() + " Lastname: " + student.getLastName() + " Cardnumber: "
          + student.getCardNumber());

    }
  }
}
