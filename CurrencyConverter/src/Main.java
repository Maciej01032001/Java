import java.util.Map;


public class Main {

    public static void main(String[] args) throws Exception {
        Map<String, Currency> currencyMap = WebScraper.scrap();
        float exchange;

        System.out.println("Current exchange rates for polish zloty:");

        for (Map.Entry<String, Currency> entry : currencyMap.entrySet()) {
            Currency currency = entry.getValue();
            System.out.printf("Name: %-20s Short: %-10s Value: %-10s Change: %s \n", currency.getName(), currency.getShortName(), currency.getValue(), currency.getChange());

        }

        System.out.println();
        exchange = Exchange.calculate(currencyMap);
        System.out.printf("Your result is: %f", exchange);
    }
}