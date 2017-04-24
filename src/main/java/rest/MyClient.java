package rest;

import model.TransactionFactory;
import model.sepa.ObjectFactory;
import model.sepa.RootType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.Service;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MyClient {
    private Service service;
    private JAXBContext jc;

    private static final QName qname = new QName("", "");
    private static final String url = "https://gscl-sepa.herokuapp.com/sepa-server/";

    private MyClient() {
        try {
            jc = JAXBContext.newInstance(RootType.class);
        } catch (JAXBException je) {
            System.out.println("Cannot create JAXBContext " + je);
        }
    }



    private void printSource(Source s) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.transform(s, new StreamResult(System.out));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void sendRequest(String urlPrefixe, String method, Source source) {
        try {
            URL mainurl = new URL(url + urlPrefixe);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) mainurl.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(method);
            if (source != null) {
                conn.setRequestProperty("Content-Type", "application/xml");
                conn.setRequestProperty("Accept", "application/xml");
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer();
                OutputStream os = conn.getOutputStream();
                transformer.transform(source, new StreamResult(os));
                os.flush();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void resume() {
        sendRequest("resume", "GET", null);
    }
    private void echo() throws JAXBException {
        sendRequest("echo", "POST", new JAXBSource(jc, TransactionFactory.exampleTransaction()));
    }

    public static void main(String args[]) throws Exception {
        MyClient client = new MyClient();
        client.senario();
    }

    public void senario() throws Exception {
        resume();
        echo();

    }

    private void print(String msg) {
        System.out.println(msg);
    }
}
