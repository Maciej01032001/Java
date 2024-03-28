import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebScraper {
    public static Map<String, Currency> Scrap() {
        int i=0;
        String name="";
        String url = "https://www.money.pl/pieniadze/nbp/srednie/";
        Map<String, Currency> currencyMap = new HashMap<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements divElements = doc.select("div.rt-td");


            for (Element div : divElements) {
                String text = div.text();
                switch (i) {
                    case 0:
                        name = text;
                        currencyMap.put(name, new Currency(name));
                        break;
                    case 1:
                        currencyMap.get(name).shortName = text;
                        break;
                    case 2:
                        currencyMap.get(name).value = text;
                        break;
                    case 3:
                        currencyMap.get(name).change = text;
                        break;
                    case 4:
                        break;
                }
                i=(i+1)%5;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    return currencyMap;

    }
}
