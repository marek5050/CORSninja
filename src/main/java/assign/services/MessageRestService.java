package assign.services;

import assign.resources.Page;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.logging.Logger;

@Path("/api")
public class MessageRestService {

    Logger log = Logger.getLogger("MessageRestService");

    public Page badRequest(String url, String method, String reason){
        Page  p = new Page(url,method);
        p.status = "Error: " + reason;

        return p;
    };




    @GET
    @Path("/request")
    @Produces("application/json")
    public Page requestURL(@QueryParam("url") String url, @QueryParam("method") String method) {
    log.warning("Type: " + method + " URL : " + url);

    if(method.isEmpty() || url.isEmpty())
        return badRequest(url,method,"Either the URL or Method is empty.");

    if(!url.startsWith("http")){
        url = "http://"+url;
    }

    Page p = new Page(url, method);
    p.processRequest();

    return p;
   }
}