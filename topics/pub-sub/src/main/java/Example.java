package learning.messaging.pubsub;
import java.util.*;
public final class Example {
 static Map<String,List<String>> publish(String event,Map<String,List<String>> subscribers){Map<String,List<String>> out=new TreeMap<>();subscribers.forEach((name,q)->{var copy=new ArrayList<>(q);copy.add(event);out.put(name,List.copyOf(copy));});return out;}
 public static void main(String[] args){System.out.println(publish("OrderPlaced",Map.of("email",List.of(),"analytics",List.of())));}
}
