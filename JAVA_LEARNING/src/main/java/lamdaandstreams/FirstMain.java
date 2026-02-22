package lamdaandstreams;

public class FirstMain {

    static void main() {
        GreetingsImpl lambda = (n) -> System.out.println(n);
        lambda.greetings("Hello Developers");
    }
}

@FunctionalInterface
interface GreetingsImpl{
    void greetings(String greeting);
}