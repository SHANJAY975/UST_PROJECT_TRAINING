package lamdaandstreams;

import java.util.function.Predicate;

public class StringEndinglambda {
    static void main() {
        StringEndings lambda = (s) -> s +"!";
        System.out.println(lambda.perform("Hello"));

        String a = "Milo";
        String b = "Tester";
        StringCompare value = (s1, s2) -> {
            if(s1.length()>s2.length()){
                return s1;
            }
            return s2;
        };

        System.out.println(value.perform(a,b));


        Predicate<Integer> lessThan100 = i->i<100;
        Predicate<Integer> greaterThan50 = i -> i>50;
//        boolean result = lessThan100.test(50);
//        System.out.println(result);

        // and Or negate
        boolean result = lessThan100.and(greaterThan50).test(40);
        System.out.println(result);

    }
}

interface StringEndings{
    String perform(String s);
}

interface StringCompare{
    String perform(String s1, String s2);
}