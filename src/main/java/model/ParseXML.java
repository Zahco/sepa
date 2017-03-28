package model;

import org.apache.cxf.helpers.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by spaurgeo on 21/03/17.
 */
public class ParseXML {

    public static String getXML(String xsdFile, String xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setNamespaceAware(true);

        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        factory.setSchema(schemaFactory.newSchema(
                new Source[] {new StreamSource(xsdFile)}));

        DocumentBuilder builder = factory.newDocumentBuilder();
        SimpleErrorHandler seh = new SimpleErrorHandler();
        builder.setErrorHandler(seh);
        builder.parse(new InputSource(xmlFile));
        List<String> lines = FileUtils.readLines(new File(xmlFile));
        String res = "";
        for (String line : lines) {
            res += line;
        }
        return res;
    }
}
