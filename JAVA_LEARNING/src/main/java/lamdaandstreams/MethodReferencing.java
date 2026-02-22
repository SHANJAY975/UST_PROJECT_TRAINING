package lamdaandstreams;

import java.util.function.Function;

public class MethodReferencing {
    static void main() {
        Function<String, Integer> countVowelsFunction = Vowels::countVowels;
        System.out.println(countVowelsFunction.apply("Umbrella"));
    }
}
