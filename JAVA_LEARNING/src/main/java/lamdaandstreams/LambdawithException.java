package lamdaandstreams;

public class LambdawithException {
    static void main() {
        Calculate divide = (a,b) -> {
            try{
                return a/b;
            } catch (ArithmeticException e) {
                e.printStackTrace();
                return -1;
            }

        };
        int solution = divide.perform(10,2);
        System.out.println(solution);
    }
}

@FunctionalInterface
interface Calculate{
    int perform(int a, int b);
}
