package server.sendmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import server.properties.ConfigProperties;
import server.report.AttendanceReportFormat;

public class SendMail
{
  private static Logger logger = Logger.getLogger(SendMail.class);

  public static void sendHTMLEmail(AttendanceReportFormat htmlReport)
  {

    ConfigProperties cfgProp = new ConfigProperties();

    String mail_to = cfgProp.getMailTo();
    String maiL_from = cfgProp.getMailFrom();

    // String to = mail_to;
    // String to = "mphare1156@gmail.com";
    String to = "mhare@zixcorp.com";
    // String to = "mphare@whitehare.com";
    String from = "prof.minerva.mcgonagall@hogwarts.edu";
    String host = "localhost";
    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", host);

    Session session = Session.getDefaultInstance(properties);
    try
    {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Test Email from Java");
      message.setContent(htmlReport.getReport(), "text/html");

      logger.debug("Sending html email to:" + to + " from: " + from);
      Transport.send(message);
      logger.debug("Sent html email to:" + to + " from: " + from);

    } catch (MessagingException mex)
    {
      mex.printStackTrace();

    }

  }
}
