import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.math.RoundingMode;


public class NumberOperations {
    private final Map<String, ArrayList<Number>> categorizedLists;

    public NumberOperations() {
        categorizedLists = new HashMap<>();
    }

    public void addNumber(Number number) {
        String typeName = number.getClass().getSimpleName();

        ArrayList<Number> list = categorizedLists.computeIfAbsent(typeName, k -> new ArrayList<>());
        list.add(number);
    }



    public void printCategorizedLists() {
        for (Map.Entry<String, ArrayList<Number>> entry : categorizedLists.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(12L);
        list.add(10);list.add(20.5);list.add(30);list.add(40.7);list.add(40.7f);list.add(new BigDecimal("121431421324232341"));list.add(50);list.add(60.3);list.add(70);list.add(80.1);list.add(90);list.add(100.9);
        System.out.println("all numbers:" + list);


        Number firstNumber = list.getFirst();
        BigDecimal firstBigDecimal = null;


        for (Number num : list) {
            if (num instanceof BigDecimal) {
                firstBigDecimal = (BigDecimal) num;
                break;
            }
        }

        if (firstBigDecimal != null) {
            BigDecimal sum = firstNumber instanceof BigDecimal ? (BigDecimal) firstNumber : new BigDecimal(firstNumber.toString());
            sum = sum.add(firstBigDecimal);
            System.out.println("Sum 1 and 1 bigdecimal: " + sum);
        }


        ArrayList<Integer> list_roundedDown = new ArrayList<>();
        ArrayList<Integer> list_roundedUp = new ArrayList<>();
        ArrayList<String> list_rounded2 = new ArrayList<>();


        for(Number i: list) {
            int n = i.intValue();
            list_roundedDown.add(n);

            double n1 = i.doubleValue();
            list_roundedUp.add((int)Math.ceil(n1));

            list_rounded2.add(String.format("%.2f", n1));


        }
        System.out.println("numbers roundedDown :" + list_roundedDown);
        System.out.println("numbers roundedUp :" + list_roundedUp);
        System.out.println("numbers rounded2 :" + list_rounded2);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");



        NumberOperations divide = new NumberOperations();

        list.forEach(divide::addNumber);

        divide.printCategorizedLists();

        // Считаем сумму
        BigDecimal sum = BigDecimal.ZERO;

        for (Object obj : list) {
            sum = switch (obj) {
                case Integer i -> sum.add(BigDecimal.valueOf(i));
                case Long l -> sum.add(BigDecimal.valueOf(l));
                case Double d -> sum.add(new BigDecimal(Double.toString(d)));
                case Float f -> sum.add(new BigDecimal(Float.toString(f)));
                case BigDecimal bigDecimal -> sum.add(bigDecimal);
                case null, default ->
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getSimpleName());
            };
        }

        BigDecimal avg = sum.divide(BigDecimal.valueOf(list.size()), 6, RoundingMode.HALF_UP);


        System.out.println("avg: " + avg.toPlainString());



    }
}