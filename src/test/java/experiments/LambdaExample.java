package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void increasePrice(){
        List<Double> prices = Arrays.asList(10.0,20.0,30.0);
        prices.replaceAll(price->price *1.1);
        prices.forEach(System.out::println);

    }
    public static void main(String[] args) {
        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);

        // Using lambda expression to print all elements
        // of arrL
        arrL.forEach(n -> System.out.println(n));
        arrL.forEach(n -> n=n+5);
        arrL.forEach(System.out::println); // OurObject::someMethod  objectName.someMethod()

        System.out.println("-------------------------------------------------");

        for (Integer integer : arrL) {
            System.out.println(integer);
        }

        for(int i = 0; i < arrL.size(); i++) {
            System.out.println(arrL.get(i));
        }
        System.out.println("-------------------------------------------------");


        // Using lambda expression to print even elements
        // of arrL
        arrL.forEach(n -> {
            if (n % 2 == 0)
                System.out.println(n);
        });
    }
}