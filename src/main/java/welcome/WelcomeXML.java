package welcome;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kittypwa on 27/04/17.
 */
@XmlRootElement
public class WelcomeXML {

    private String autheurs;
    private String date;
    private static final String bienvenu = "Bienvenu au rendu final du projet de Language Web du M1GIL";

    public WelcomeXML(String autheurs, String date) {
        this.autheurs = autheurs;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getAutheurs() {
        return autheurs;
    }

    public static String getBienvenu() {
        return bienvenu;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAutheurs(String autheurs) {
        this.autheurs = autheurs;
    }
}
