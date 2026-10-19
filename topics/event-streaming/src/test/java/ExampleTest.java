package learning.messaging.stream;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void supportsReplayFromConsumerOffset() { var l=new Example.Log();l.append("a");l.append("b");assertEquals(java.util.List.of("a","b"),l.read(0,10));assertEquals(java.util.List.of("b"),l.read(1,1)); }
 @Test void consumersDoNotDestructivelyRemoveLog() { var l=new Example.Log();l.append("x");l.read(0,1);assertEquals(1,l.size()); }
}
