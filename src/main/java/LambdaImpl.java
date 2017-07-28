import org.junit.Test;

public class LambdaImpl {
    /**
     * mostly from here: http://www.oracle.com/technetwork/articles/java/architect-lambdas-part1-2080972.html
     */

    @Test
    public void runningTest() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("from runnable - simple");
            }
        };
        r.run();

        // using lambda:
        Runnable r2 = () -> System.out.println("from runnable - lambda");
        r2.run();
    }

    @Test
    public void otherImpls() {
        LambdaImpl li = new LambdaImpl();

        // with type declaration
        MathOperation addition = (int a , int b) -> a + b;
        MathOperation subtraction = (int a, int b) -> a - b;
        // without type declaration
        MathOperation division = (a, b) -> a / b;
        // with curly braces
        MathOperation mulitplication = (int a, int b) -> {return a * b;};

        // running them
        System.out.println(addition.operation(1,2));
        System.out.println(operate(3,4, subtraction));

        // without parenthesis
        GreetingService greetingService = message -> System.out.println(message);
        greetingService.sayMessage("this is a test msg");
    }



    ////////////////////////////
    //////// UTILITIES /////////
    ////////////////////////////

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String msg);
    }

    private int operate(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }
}
