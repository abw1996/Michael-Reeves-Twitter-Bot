import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class Scraper {

    private String url = "https://socialblade.com/youtube/channel/UCtHaxi4GTYDpJgMSGy7AeSw/realtime";
    private String subsAsString = "";
    private Document doc;
    private Element sub;

    {
        try {
            doc = Jsoup.connect(url).userAgent("Scraper").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int scrape() {
        sub = doc.getElementById("rawCount");
        subsAsString = sub.text();
        return(Integer.parseInt(subsAsString));
    }
}
