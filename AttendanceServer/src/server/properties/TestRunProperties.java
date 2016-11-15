package server.properties;

public class TestRunProperties
{

  public enum Contract
  {
    loadTestBrooklynServerUri, testServiceUri, defaultPasscode, defaultPassword, emailPrefix, emailStartingNumber, emailEndingNumber, emailDomain, threads, stepTime, stepMinRuntime, numToRecipients, unsetRatio, iosRatio, androidRatio, percentReadToggle, percentFlagToggle, numMessages, accountProfile;
  }

  private static String  uri;
  private static String  testUri;
  private static String  passcode;
  private static String  emailPassword;
  private static Integer emailStartingNumber;
  private static Integer emailEndingNumber;
  private static String  emailPrefix;
  private static String  emailDomain;
  private static Integer threadPoolSize;
  private static Long    stepTime;
  private static Long    stepMinRuntime;
  private static Integer numToRecipients;
  private static Double  percentReadToggle;
  private static Double  percentFlagToggle;

  private static Integer iosRatio;
  private static Integer androidRatio;
  private static Integer unsetRatio;

  private static Integer numMessages;
  private static String  accountProfile;

  public static String getAcountProfile()
  {
    if (accountProfile == null)
    {
      accountProfile = System.getProperty(Contract.accountProfile.toString());
    }

    return accountProfile;
  }

  public static Integer getNumMessages()
  {
    if (numMessages == null)
    {
      numMessages = Integer.getInteger(Contract.numMessages.toString());
    }

    return numMessages;
  }

  public static Integer getIosRatio()
  {
    if (iosRatio == null)
    {
      iosRatio = Integer.getInteger(Contract.iosRatio.toString());
    }

    return iosRatio;
  }

  public static void setIosRatio(Integer iosRatio)
  {
    TestRunProperties.iosRatio = iosRatio;
  }

  public static Integer getAndroidRatio()
  {
    if (androidRatio == null)
    {
      androidRatio = Integer.getInteger(Contract.androidRatio.toString());
    }

    return androidRatio;
  }

  public static void setAndroidRatio(Integer androidRatio)
  {

    TestRunProperties.androidRatio = androidRatio;
  }

  public static Integer getUnsetRatio()
  {
    if (unsetRatio == null)
    {
      unsetRatio = Integer.getInteger(Contract.unsetRatio.toString());
    }

    return unsetRatio;
  }

  public static void setUnsetRatio(Integer unsetRatio)
  {
    TestRunProperties.unsetRatio = unsetRatio;
  }

  public static String getUri()
  {
    if (uri == null)
    {
      uri = System.getProperty(Contract.loadTestBrooklynServerUri.toString());
    }
    return uri;
  }

  public static String getTestUri()
  {
    if (testUri == null)
    {
      testUri = System.getProperty(Contract.testServiceUri.toString());
    }

    return testUri;
  }

  public static String getPasscode()
  {
    if (passcode == null)
    {
      passcode = System.getProperty(Contract.defaultPasscode.toString());
    }
    return passcode;
  }

  public static String getEmailPassword()
  {
    if (emailPassword == null)
    {
      emailPassword = System.getProperty(Contract.defaultPassword.toString());
    }

    return emailPassword;
  }

  public static int getEmailStartRange()
  {
    if (emailStartingNumber == null)
    {
      emailStartingNumber = Integer.getInteger(Contract.emailStartingNumber.toString());
    }

    return emailStartingNumber;
  }

  public static int getEmailEndRange()
  {
    if (emailEndingNumber == null)
    {
      emailEndingNumber = Integer.getInteger(Contract.emailEndingNumber.toString());
    }

    return emailEndingNumber;
  }

  public static String getEmailPrefix()
  {
    if (emailPrefix == null)
    {
      emailPrefix = System.getProperty(Contract.emailPrefix.toString());
    }

    System.out.println("(from Property bag) Email Prefix: " + emailPrefix);
    return emailPrefix;
  }

  public static String getEmailDomain()
  {
    if (emailDomain == null)
    {
      emailDomain = System.getProperty(Contract.emailDomain.toString());
    }

    return emailDomain;
  }

  public static int getThreadPoolSize()
  {
    if (threadPoolSize == null)
    {
      threadPoolSize = Integer.getInteger(Contract.threads.toString());
    }

    return threadPoolSize;
  }

  public static Long getStepTime()
  {
    if (stepTime == null)
    {
      stepTime = Long.getLong(Contract.stepTime.toString());
    }

    return stepTime;

  }

  public static long getStepMinRuntime()
  {
    if (stepMinRuntime == null)
    {
      stepMinRuntime = Long.getLong(Contract.stepMinRuntime.toString());
    }

    return stepMinRuntime;

  }

  public static int getNumToRecipients()
  {
    if (numToRecipients == null)
    {
      numToRecipients = Integer.getInteger(Contract.numToRecipients.toString());
    }

    return numToRecipients;
  }

  public static double getPercentReadToggle()
  {
    if (percentReadToggle == null)
    {
      percentReadToggle = Double.parseDouble(System.getProperty(Contract.percentReadToggle.toString()));
    }

    return percentReadToggle;
  }

  public static double getPercentFlagToggle()
  {
    if (percentFlagToggle == null)
    {
      percentFlagToggle = Double.parseDouble(System.getProperty(Contract.percentFlagToggle.toString()));
    }

    return percentFlagToggle;
  }
}
