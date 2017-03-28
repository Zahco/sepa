package rest;

import model.*;
import model.sepa.ObjectFactory;
import model.sepa.RootType;
import org.xml.sax.SAXException;

import javax.ws.rs.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;


public class MyServiceTP {

    public final static String dirres = "/home/m1gil/spaurgeo/sepa/src/main/resources/";

    public MyServiceTP() {
        // Fill our center with some animals

    }

    /**
     * GET method bound to calls on /animals/{something}
     */
    @GET
    @Path("/resume")
    @Produces("application/xml")
    public String resume() throws Exception {
        String source = dirres + "tp1.sepa.011.xml";
        String xsdFile = dirres + "tp1.sepa.01.xsd";
        String xml = ParseXML.getXML(xsdFile, source);
        return xml;
    }


    @POST
    @Path("/echo")
    @Consumes("application/xml")
    public JAXBElement<RootType> echo(RootType sepa) {
//        return sepa.getDrctDbtTxInf().stream().findFirst().get().getDbtrAgt().getBIC();
        return new ObjectFactory().createCstmrDrctDbtInitn(sepa);
    }

}
