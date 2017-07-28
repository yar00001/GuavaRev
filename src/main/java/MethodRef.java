import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MethodRef {
    /**
     * Method references:
     *  A method reference can be used to point the following types of methods −
     Static methods
     Instance methods
     Constructors using new operator (TreeSet::new)

     from here: https://blog.idrsolutions.com/2015/02/java-8-method-references-explained-5-minutes/
     */


    /**
     * 1- reference to static method
     */
    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List findPrimeNumbers(List list, Predicate predicate) {
        List sortedNumbers = new ArrayList();
        list.stream().filter((i) -> {
            return (predicate.test(i));
        }).forEach((i) -> {sortedNumbers.add(i);});
        return sortedNumbers;
    }

    @Test
    public void findPrimeTest() {
        List numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);
        List primeNumbers = findPrimeNumbers(numbers, (number) -> isPrime((int) number));
        System.out.println("Prime nums are: " + primeNumbers);
    }


}
