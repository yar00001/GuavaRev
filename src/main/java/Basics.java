import model.Computer;
import model.Soundcard;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Basics {

    Optional<Computer> computer;
    Optional<Soundcard> soundcard;

    public Basics() {
        Soundcard sc = new Soundcard();
        sc.setVersion("2.3");
        soundcard = Optional.of(sc);

        Computer comp = new Computer();
        computer = Optional.of(comp);
    }

    /**
     * instead of a sparse list, use Map<Integer, E>
     *     to avoid null values in the other indexes
     */
    void SparseList() {
        // bad practice
        List<User> userList = new ArrayList<>();
        userList.set(10, new User());
        // better approach
        Map<Integer, User> map = new HashMap<>();
        map.put(10, new User());
    }

    /**
     * using Optional<T>
     *     used to replace a nullable T reference with a non-null value.
     *     An Optional may either contain a non-null T reference (in which case we say the reference is "present"),
     *     or it may contain nothing (in which case we say the reference is "absent").
     *     It is never said to "contain null."
     *
     *     You can view Optional as a single-value container that either contains a value or doesn't (it is then said to be "empty")
     *     the advantage compared to null references is that the Optional class forces you to think about the case when the value is not present.
     *     JAVA 8 HAS ADDED THE IMPLEMENTATION: http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
     */
    void OptionalImpl() {
        // bad approach:
        String versionName = "UNKNOWN";
        if (computer != null) {
            if (soundcard != null) {
                // versionName = soundcard.getVersion();
            }
        }
    }

    void OptionalImpl2() {
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent();   // true
        possible.get();         // 5
    }
}
