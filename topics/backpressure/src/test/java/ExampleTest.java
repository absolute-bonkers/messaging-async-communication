package learning.messaging.backpressure;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void fullBufferRejectsAdditionalWorkUntilDemandFreesCapacity() { var b=new Example.BoundedBuffer<Integer>(1);assertTrue(b.offer(1));assertFalse(b.offer(2));assertEquals(1,b.poll().orElseThrow());assertTrue(b.offer(2)); }
 @Test void rejectsUnboundedCapacityConfiguration() { assertThrows(IllegalArgumentException.class,()->new Example.BoundedBuffer<>(0)); }
}
