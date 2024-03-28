import java.util.Map;
import java.util.Scanner;

public class Exchange {
    public static float Calculate(Map<String, Currency> currencyMap) throws Exception {
        boolean find = false;
        float result;
        float rate = 0;
        String sValue;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter short name of a currency: ");
        String name = scanner.nextLine();
        System.out.println("Please enter value to calculate: ");
        float value = scanner.nextFloat();
        for (Map.Entry<String, Currency> entry : currencyMap.entrySet()) {
            String sName = entry.getValue().shortName;
            if (sName.equals(name)) {
                sValue = entry.getValue().value.replaceAll(",", ".");
                rate = Float.parseFloat(sValue);
                find = true;
            }
        }
        if(find) {
            result = value * rate;
        }
        else {
            //System.out.println("I didn't find this short name");
            throw new Exception("I didn't find this short name");
        }
        return result;
    }
}
