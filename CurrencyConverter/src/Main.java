import java.util.Map;


public class Main {

    public static void main(String[] args) throws Exception {
        Map<String, Currency> currencyMap = WebScraper.Scrap();
        float exchange;

        System.out.println("Current exchange rates for polish zloty:");

        for (Map.Entry<String, Currency> entry : currencyMap.entrySet()) {
            Currency value = entry.getValue();
            System.out.printf("Name: %-20s Short: %-10s Value: %-10s Change: %s \n", value.name, value.shortName, value.value, value.change);

        }

        System.out.println();
        exchange = Exchange.Calculate(currencyMap);
        System.out.printf("Your result is: %f", exchange);
    }
}