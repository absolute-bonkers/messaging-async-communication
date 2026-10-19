package learning.messaging.queue;
import java.util.*;
public final class Example {
 static final class Queue {private final Deque<String> ready=new ArrayDeque<>();private final Map<String,String> inFlight=new HashMap<>();void send(String id,String body){ready.add(id+"|"+body);}Optional<String> receive(){if(ready.isEmpty())return Optional.empty();String m=ready.remove();String id=m.substring(0,m.indexOf('|'));inFlight.put(id,m);return Optional.of(m);}void ack(String id){inFlight.remove(id);}void retry(String id){String m=inFlight.remove(id);if(m!=null)ready.addFirst(m);}int pending(){return ready.size()+inFlight.size();}}
 public static void main(String[] args){var q=new Queue();q.send("1","hello");System.out.println(q.receive());}
}
