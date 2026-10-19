package learning.messaging.saga;
import java.util.*;
public final class Example {
 enum Step { RESERVED,CHARGED,COMPENSATED }
 static List<Step> compensateAfterChargeFailure(){return List.of(Step.RESERVED,Step.COMPENSATED);}
 static String controlPlane(boolean orchestration){return orchestration?"coordinator sends commands":"services react to events";}
 public static void main(String[] args){System.out.println(compensateAfterChargeFailure());}
}
