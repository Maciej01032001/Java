import java.util.Map;
import java.util.Scanner;

public class Exchange {
    public static float calculate(Map<String, Currency> currencyMap) throws Exception {
        boolean found = false;
        float result;
        float rate = 0;
        String stringCurrencyValue;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter short name of a currency: ");
        String inputName = scanner.nextLine();
        System.out.println("Please enter value to calculate: ");
        float value = scanner.nextFloat();

        for (Map.Entry<String, Currency> entry : currencyMap.entrySet()) {
            String shortName = entry.getValue().getShortName();
            if (shortName.equals(inputName)) {
                stringCurrencyValue = entry.getValue().getValue().replaceAll(",", ".");
                rate = Float.parseFloat(stringCurrencyValue);
                found = true;
            }
        }

        if (found) {
            result = value * rate;
        } else {
            throw new Exception("I didn't find this short name");
        }

        return result;
    }
}
