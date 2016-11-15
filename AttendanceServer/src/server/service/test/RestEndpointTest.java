package server.service.test;

import java.io.InputStream;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/test")
public class RestEndpointTest
{
  private static Logger logger = Logger.getLogger(RestEndpointTest.class);

  @GET
  @Path("/get")
  @Produces("application/xml")
  public String getTest(InputStream incomingData)
  {
    String result = "The Test Endpoint was Hit";
    logger.debug("Server Get Test 1");
    return "<ctofservice>" + "<celsius>" + "XYZZY" + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
        + "</ctofservice>";

  }

  @GET
  @Path("/get2")
  @Produces(MediaType.TEXT_PLAIN)
  public String getTest2(InputStream incomingData)
  {
    String result = "The 2nd Test Endpoint was Hit";
    logger.debug("Server Get Test 2");

    return "<ctofservice>" + "<celsius>" + "ABC123" + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
        + "</ctofservice>";

  }

  @Path("put")
  @PUT
  @Produces(MediaType.TEXT_PLAIN)
  public String putTest(@QueryParam("cardnum") String cardnum, @QueryParam("classroom") String classroom)
  {
    logger.debug("Server Put Test: " + cardnum + " Classroom: " + classroom);
    // UpdateEntry ue = new UpdateEntry();
    // ue.updateNameType(idx, name, type);
    return "Card: " + cardnum + " swipe detected in Classroom:" + classroom;
  }

  @Path("post")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String postTest(@QueryParam("studentid") String studentid)
  {
    logger.debug("Server Post Test: " + studentid);
    return "Posted " + studentid;
  }

  @Path("delete")
  @DELETE
  @Produces(MediaType.TEXT_PLAIN)
  public String deleteTest(@QueryParam("studentid") String studentid)
  {
    logger.debug("Server Delete Test: " + studentid);
    return "Deleted " + studentid;
  }
}
