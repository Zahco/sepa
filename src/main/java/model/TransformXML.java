package model;

import java.io.File;
import java.io.StringReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformXML {
	public static void transform_XML(String sourcePath, String xsltPath, String resultDir) {
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
			transformer.transform(new StreamSource(new File(sourcePath)), new StreamResult(new File(resultDir)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getXML(String sourceXml, String xsltPath) throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        String result = "";
        StreamSource source = new StreamSource(new StringReader(sourceXml));
        try {
            Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
            transformer.transform(source, new StreamResult(result));
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
