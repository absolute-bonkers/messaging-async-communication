package learning.messaging.queue;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void messageRemainsPendingUntilAcknowledged() { var q=new Example.Queue();q.send("1","work");var delivery=q.receive().orElseThrow();assertEquals("work",delivery.body());assertEquals(1,q.pending());q.ack(delivery.receipt());assertEquals(0,q.pending()); }
 @Test void unacknowledgedWorkCanBeRetried() { var q=new Example.Queue();q.send("2","x");var first=q.receive().orElseThrow();q.retry(first.receipt());var retried=q.receive().orElseThrow();assertEquals(first.id(),retried.id());assertEquals(first.body(),retried.body()); }
 @Test void receiptHandlesAndTypedMessagesPreserveDuplicateIdsAndDelimiterCharacters() { var q=new Example.Queue();q.send("same|id","one");q.send("same|id","two");var first=q.receive().orElseThrow();var second=q.receive().orElseThrow();q.ack(first.receipt());assertEquals(1,q.pending());assertEquals("same|id",second.id());assertEquals("two",second.body()); }
}
