package server.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import server.beans.CardSwipe;
import server.controller.CreateSwipe;

@Path("/send")
public class SwipeServiceCenter
{
  private static Logger logger = Logger.getLogger(SwipeServiceCenter.class);

  @Path("swipe")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String newCardSwipe(@QueryParam("cardnumber") String cardnumber, @QueryParam("classroom") String classroom)
  {
    // Date date = new Date();
    CardSwipe cs = new CardSwipe(cardnumber, classroom);
    logger.debug("Card Swipe Detected. Cardnumber: " + cardnumber + " Classroom:" + classroom);

    CreateSwipe ccs = new CreateSwipe();
    // ccs.saveNameType(cardnumber, classroom);
    ccs.saveCardSwipe(cs);

    return "Card: " + cardnumber + " swipe detected in Classroom:" + classroom;
  }
}
