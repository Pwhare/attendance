package server.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties
{

  InputStream    inputStream;

  private String mailTo   = "";
  private String mailFrom = "";

  public void getPropertyValue() throws IOException
  {
    try
    {
      Properties prop = new Properties();
      String configPropertyFileName = "config.properties";

      inputStream = getClass().getClassLoader().getResourceAsStream(configPropertyFileName);
      if (inputStream != null)
      {
        prop.load(inputStream);

      } else
      {
        throw new FileNotFoundException("Property File: '" + configPropertyFileName + "' was not found");
      }

      mailTo = prop.getProperty("report_mail_to");
      mailFrom = prop.getProperty("report_mail_from");

    } catch (Exception e)
    {
      e.printStackTrace();
    } finally
    {
      inputStream.close();
    }
  }

  public String getMailTo()
  {
    return mailTo;
  }

  public void setMailTo(String mailTo)
  {
    this.mailTo = mailTo;
  }

  public String getMailFrom()
  {
    return mailFrom;
  }

  public void setMailFrom(String mailFrom)
  {
    this.mailFrom = mailFrom;
  }

}
