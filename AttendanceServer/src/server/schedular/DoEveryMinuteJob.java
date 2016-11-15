package server.schedular;

import java.util.Date;

import org.apache.log4j.Logger;

import server.tasks.AttendanceReport;

public class DoEveryMinuteJob implements Runnable
{
  private static Logger logger = Logger.getLogger(DoEveryMinuteJob.class);

  @Override
  public void run()
  {
    AttendanceReport ar = new AttendanceReport();

    Date date = new Date();
    logger.info("It's ben a minute: " + date.toString());
    ar.generateAttendanceReport(date);
  }

}
