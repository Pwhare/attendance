package scanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties
{
  String      result    = "";
  InputStream inputStream;

  String      serverURI = "";
  String      classRoom = "";

  public void getPropertyValues() throws IOException
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

      serverURI = prop.getProperty("attendance_server_uri");
      classRoom = prop.getProperty("class_room");

    } catch (Exception e)
    {
      e.printStackTrace();
    } finally
    {
      inputStream.close();
    }
  }

  public String getServerURI()
  {
    return serverURI;
  }

  public void setServerURI(String serverURI)
  {
    this.serverURI = serverURI;
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
