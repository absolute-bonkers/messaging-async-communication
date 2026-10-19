package learning.messaging.saga;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void compensationRecordsBusinessRecoveryStep() { assertEquals(java.util.List.of(Example.Step.RESERVED,Example.Step.COMPENSATED),Example.compensateAfterChargeFailure()); }
 @Test void distinguishesCoordinationStyles() { assertNotEquals(Example.controlPlane(true),Example.controlPlane(false)); }
}
