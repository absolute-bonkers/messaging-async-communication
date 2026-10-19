package learning.messaging.dlq;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void routesPoisonMessageAfterRetryLimit() { assertTrue(Example.outcome(3,3).deadLetter());assertFalse(Example.outcome(2,3).deadLetter()); }
 @Test void rejectsInvalidRetryPolicy() { assertThrows(IllegalArgumentException.class,()->Example.outcome(0,0)); }
}
