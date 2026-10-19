package learning.messaging.pubsub;
import org.junit.jupiter.api.Test;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void eventIsDeliveredToEveryIndependentSubscription() { var out=Example.publish("created",Map.of("email",List.of(),"metrics",List.of("old")));assertEquals(List.of("created"),out.get("email"));assertEquals(List.of("old","created"),out.get("metrics")); }
 @Test void publisherCanPublishWithNoSubscribers() { assertTrue(Example.publish("x",Map.of()).isEmpty()); }
}
