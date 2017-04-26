package rest;

import model.ParseXML;
import model.sepa.RootType;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import static model.TransactionFactory.exampleTransaction;

/**
 * Created by spaurgeo on 28/03/17.
 */
public class TestMaker {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(RootType.class);
        OutputStream os = new ByteArrayOutputStream();
        context.createMarshaller().marshal(exampleTransaction(), os);
        System.out.println(os);
        System.out.println((RootType)context.createUnmarshaller().unmarshal(new ByteArrayInputStream(os.toString().getBytes())));
    }
}
