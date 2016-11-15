package scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunScanner
{
  private static String classRoom = "0000";

  public static void main(String[] args)
  {
    String cardNumber = "000000";

    CardSwipe cs = new CardSwipe();
    ConfigProperties cfgProp = new ConfigProperties();

    try
    {
      cfgProp.getPropertyValues();
    } catch (IOException e1)
    {
      e1.printStackTrace();
    }

    // Get the clss room from the properties file
    classRoom = cfgProp.getClassRoom();
    BufferedReader br = null;

    try
    {
      // open the connection to the card reader
      br = new BufferedReader(new InputStreamReader(System.in));

      while (true)
      {
        System.out.println("Card Number: ");

        // Read the card number from the card reader
        cardNumber = br.readLine();

        // enter the letter 'q' to quit reading
        if ("q".equals(cardNumber))
        {
          System.out.println("Exit!");
          System.exit(0);
        }
        cs.sendSwipedCard(cardNumber, classRoom);
      }
    } catch (IOException e)

    {
      e.printStackTrace();
    } catch (Exception e)

    {
      e.printStackTrace();
    } finally
    {
      if (br != null)
      {
        try
        {
          br.close();
        } catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }
  }

}
