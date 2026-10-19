package learning.messaging.delivery;
import org.junit.jupiter.api.Test;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void preservesInputOrderWithinOnePartition() { assertEquals(List.of("1","2","3"),Example.ordered(List.of("1","2","3"))); }
 @Test void stableIdsMakeRepeatedEffectsDeduplicable() { assertEquals(List.of("e1","e2"),new ArrayList<>(Example.applyOnce(List.of("e1","e1","e2")))); }
}
