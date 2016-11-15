package server.listener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import server.schedular.DoEveryMinuteJob;

@WebListener
public class MyServletContextListener implements ServletContextListener
{
  private static Logger            logger = Logger.getLogger(MyServletContextListener.class);

  private ScheduledExecutorService scheduler;

  @Override
  public void contextDestroyed(ServletContextEvent event)
  {
    scheduler.shutdownNow();
    logger.info("Servlet Context Destroyed");

  }

  @Override
  public void contextInitialized(ServletContextEvent event)
  {
    logger.info("Servlet Context Initialized");
    scheduler = Executors.newSingleThreadScheduledExecutor();
    // Wait 1 minute, then every minute afterward
    scheduler.scheduleAtFixedRate(new DoEveryMinuteJob(), 1, 1, TimeUnit.MINUTES);

  }

}
