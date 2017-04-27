package welcome;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kittypwa on 27/04/17.
 */
@XmlRootElement
public class WelcomeXML {

    private String auteurs;
    private String date;

    public String getDate() {
        return date;
    }

    public String getAuteurs() {
        return auteurs;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuteurs(String auteurs) {
        this.auteurs = auteurs;
    }
}
