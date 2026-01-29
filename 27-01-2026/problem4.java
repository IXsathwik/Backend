import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class problem4 {

    public static void main(String[] args) {

        
        String[] inputs = {"10", "20", "5.5", "3.2", "abc", "15", "7.8"};

    
        List<Number> numbers = new ArrayList<>();

        
        for (String value : inputs) {
            try {
                if (value.contains(".")) {
                    Double d = Double.parseDouble(value); 
                    numbers.add(d); 
                } else {
                    Integer i = Integer.parseInt(value); 
                    numbers.add(i); 
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input ignored: " + value);
            }
        }

        int intSum = 0;
        double doubleSum = 0.0;
        int doubleCount = 0;


        Iterator<Number> it = numbers.iterator();
        while (it.hasNext()) {
            Number num = it.next();

            if (num instanceof Integer) {
                intSum += num.intValue(); 
            } else if (num instanceof Double) {
                doubleSum += num.doubleValue(); 
                doubleCount++;
            }
        }

        double average = (doubleCount > 0) ? doubleSum / doubleCount : 0;

    
        System.out.println("\nStored Numbers: " + numbers);
        System.out.println("Sum of Integers: " + intSum);
        System.out.println("Average of Floating Numbers: " + average);
    }
}
