package experiments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    public static void main(String[] args) {
        //mailSearcher();
        //phoneSearcher();
        phoneStringSearcher();
    }
    public static void mailSearcher(){
        String input = "Hello, this is my email: mytestmail@mail.com";
        Pattern pattern =
                Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            String email = matcher.group();
            System.out.println("My email is: " + email);
        }
    }

    public static void phoneSearcher(){
        String input =
                "Hello, this is my email: mytestmail@mail.com and my phone number: +1(123) 456-7839";
        Pattern pattern =
                Pattern.compile("\\+\\d{1,3}\\s?\\(?(\\d{3})\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            String phone = matcher.group();
            System.out.println("My phone number is: " + phone);
        }
    }

    public static void phoneStringSearcher(){
        String myString = "This is my email: ";
        Pattern pattern = Pattern.compile("i.+i");
        Matcher matcher = pattern.matcher(myString);
        while (matcher.find()){
            System.out.println(myString.substring(matcher.start(), matcher.end()));
        }
    }
}
