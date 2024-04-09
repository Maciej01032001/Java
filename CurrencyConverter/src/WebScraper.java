import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebScraper {
    private static final String SCRAP_URL = "https://www.money.pl/pieniadze/nbp/srednie/";
    public static Map<String, Currency> scrap() {
        int i=0;
        String name="";
        Map<String, Currency> currencyMap = new HashMap<>();

        try {
            Document doc = Jsoup.connect(SCRAP_URL).get();
            Elements divElements = doc.select("div.rt-td");


            for (Element div : divElements) {
                String text = div.text();
                switch (i) {
                    case 0:
                        name = text;
                        currencyMap.put(name, new Currency(name));
                        break;
                    case 1:
                        currencyMap.get(name).setShortName(text);
                        break;
                    case 2:
                        currencyMap.get(name).setValue(text);
                        break;
                    case 3:
                        currencyMap.get(name).setChange(text);
                        break;
                    case 4:
                        //empty case as div produce empty line we don't want to use
                        break;
                }
                //divs on the website are arranged in certain order name, shortName, value, change, emptyLine
                i=(i+1)%5;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    return currencyMap;

    }
}
