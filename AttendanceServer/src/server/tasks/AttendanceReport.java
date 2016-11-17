package server.tasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import server.controller.GetStudents;
import server.controller.GetSwipes;
import server.persistence.CardSwipes;
import server.persistence.Students;
import server.report.AttendanceReportFormat;
import server.sendmail.SendMail;

public class AttendanceReport
{
  private static Logger logger = Logger.getLogger(AttendanceReport.class);

  public void generateAttendanceReport(Date date)
  {
    logger.info("About to generate the Attendance Report for " + date.toString());

    GetSwipes getSwipes = new GetSwipes();
    List<CardSwipes> cardswipes = new ArrayList<CardSwipes>();
    List<CardSwipes> tardycardswipes = new ArrayList<CardSwipes>();

    Calendar calNow = Calendar.getInstance();
    Date endDate = calNow.getTime();

    calNow.add(Calendar.MINUTE, -2);
    Date tardyDate = calNow.getTime();

    calNow.add(Calendar.MINUTE, -1);
    Date startDate = calNow.getTime();

    logger.info("Tardy start time: " + tardyDate + " to " + endDate);
    tardycardswipes = getSwipes.getRangeCardSwipes(tardyDate, endDate);
    logger.info("Present start time: " + startDate + " to " + tardyDate);
    cardswipes = getSwipes.getRangeCardSwipes(startDate, tardyDate);

    if (cardswipes.size() > 0)
    {
      logger.info("Getting swipes in the last 3 minutes: Time of report is:" + endDate + "  Time class started is: "
          + startDate);

      for (CardSwipes cardswipe : tardycardswipes)
      {
        logger.info("Card Number: " + cardswipe.getCardNumber() + " was validated at " + cardswipe.getSwipeTime());
      }

      for (CardSwipes cardswipe : cardswipes)
      {
        logger.info("Card Number: " + cardswipe.getCardNumber() + " was validated at " + cardswipe.getSwipeTime());
      }

      System.out.println("Attendance Report for " + startDate + " to " + endDate);

      GetStudents getsalltudents = new GetStudents();
      List<Students> allstudents = getsalltudents.getAllStudents();

      AttendanceReportFormat htmlReport = new AttendanceReportFormat();
      htmlReport.buildHTMLReport(allstudents, cardswipes, tardycardswipes);
      SendMail sendMail = new SendMail();
      sendMail.sendHTMLEmail(htmlReport);

      for (Students student : allstudents)
      {
        String cardID = student.getCardNumber();
        System.out.print("Firstname: " + student.getFirstName() + ", Lastname: " + student.getLastName()
            + ", Cardnumber: " + student.getCardNumber());

        String attendance = "Absent";

        for (CardSwipes cardswipe : cardswipes)
        {
          String swipeCardID = cardswipe.getCardNumber();
          if (cardID.equals(swipeCardID))
          {
            attendance = "Present";
            break;
          }
        }

        for (CardSwipes cardswipe : tardycardswipes)
        {
          String swipeCardID = cardswipe.getCardNumber();
          if (cardID.equals(swipeCardID))
          {
            attendance = "Tardy";
            break;
          }
        }

        System.out.println(", Attendance: " + attendance);

      }
    } else
    {
      logger.info("No card swipes for this time period");
    }

  }

}
