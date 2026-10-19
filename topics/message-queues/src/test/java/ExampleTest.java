package learning.messaging.queue;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void messageRemainsPendingUntilAcknowledged() { var q=new Example.Queue();q.send("1","work");assertEquals("1|work",q.receive().orElseThrow());assertEquals(1,q.pending());q.ack("1");assertEquals(0,q.pending()); }
 @Test void unacknowledgedWorkCanBeRetried() { var q=new Example.Queue();q.send("2","x");q.receive();q.retry("2");assertEquals("2|x",q.receive().orElseThrow()); }
}
