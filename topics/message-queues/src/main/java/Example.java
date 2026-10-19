package learning.messaging.queue;
import java.util.*;
public final class Example {
 record Message(String id,String body) {}
 record Delivery(String receipt,String id,String body) {}
 static final class Queue {private final Deque<Message> ready=new ArrayDeque<>();private final Map<String,Message> inFlight=new HashMap<>();private long nextReceipt;
  void send(String id,String body){ready.addLast(new Message(Objects.requireNonNull(id),Objects.requireNonNull(body)));}
  Optional<Delivery> receive(){if(ready.isEmpty())return Optional.empty();Message message=ready.removeFirst();String receipt=Long.toString(++nextReceipt);inFlight.put(receipt,message);return Optional.of(new Delivery(receipt,message.id(),message.body()));}
  void ack(String receipt){inFlight.remove(receipt);}
  void retry(String receipt){Message message=inFlight.remove(receipt);if(message!=null)ready.addFirst(message);}
  int pending(){return ready.size()+inFlight.size();}}
 public static void main(String[] args){var q=new Queue();q.send("1","hello");System.out.println(q.receive());}
}
