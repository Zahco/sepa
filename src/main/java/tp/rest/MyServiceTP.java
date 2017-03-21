package tp.rest;

import tp.model.*;

import javax.ws.rs.*;
import javax.xml.bind.JAXBException;
import javax.xml.ws.http.HTTPException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

@Path("/sepa-server/")
public class MyServiceTP {


    public MyServiceTP() {
        // Fill our center with some animals

    }

    /**
     * GET method bound to calls on /animals/{something}
     */
    @GET
    @Path("/resume")
    @Produces("application/xml")
    public String resume() throws JAXBException {
        return "<b>Hello World</b>";
    }


}
