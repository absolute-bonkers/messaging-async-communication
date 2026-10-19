package learning.messaging.outbox;
import java.util.*;
public final class Example {
 record State(String orderId,String status,List<String> outbox) {}
 static State place(String id){return new State(id,"PLACED",List.of("OrderPlaced:"+id));}
 static List<String> relay(State s,Set<String> published){return s.outbox().stream().filter(e->!published.contains(e)).toList();}
 public static void main(String[] args){var s=place("o-7");System.out.println(s+" relay="+relay(s,Set.of()));}
}
