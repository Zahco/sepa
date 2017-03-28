package rest;

import model.ParseXML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by spaurgeo on 28/03/17.
 */
public class TestMaker {

    public final static String dirres = "src/main/resources/";

    public static void main(String[] args) throws Exception {
        String source = dirres + "tp1.sepa.011.xml";
        String xsdFile = dirres + "tp1.sepa.01.xsd";
        String xml = ParseXML.getXML(xsdFile, source);
        System.out.println(xml);
    }
}
