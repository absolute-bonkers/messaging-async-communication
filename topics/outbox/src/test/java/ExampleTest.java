package learning.messaging.outbox;
import org.junit.jupiter.api.Test;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void businessChangeAndEventAreRepresentedTogether() { var s=Example.place("o1");assertEquals("PLACED",s.status());assertEquals(List.of("OrderPlaced:o1"),s.outbox()); }
 @Test void relaySkipsAlreadyPublishedEventIds() { var s=Example.place("o1");assertTrue(Example.relay(s,Set.of("OrderPlaced:o1")).isEmpty()); }
}
