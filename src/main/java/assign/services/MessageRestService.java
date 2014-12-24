package assign.services;

import assign.resources.Page;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;


@Path("/api")
public class MessageRestService {

    Logger log = Logger.getLogger("MessageRestService");

    @GET
    @Path("request")
    @Produces("application/json")
    public Response requestURL(@QueryParam("url") String url, @QueryParam("method") String method, @QueryParam("callback") String callback) {
        log.warning("Type: " + method + " URL : " + url + " Callback: " + callback);
        Response.ResponseBuilder resp = Response.ok();

    if(!url.startsWith("http")){
        url = "http://"+url;
    }

    Page p = new Page(url, method);
    p.processRequest();
    resp.entity(p);
     return   resp.build();
    }
}