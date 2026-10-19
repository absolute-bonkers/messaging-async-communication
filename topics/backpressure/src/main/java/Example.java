package learning.messaging.backpressure;
import java.util.*;
public final class Example {
 static final class BoundedBuffer<T>{private final int capacity;private final Deque<T> q=new ArrayDeque<>();BoundedBuffer(int c){if(c<1)throw new IllegalArgumentException();capacity=c;}boolean offer(T x){if(q.size()==capacity)return false;q.addLast(x);return true;}Optional<T> poll(){return Optional.ofNullable(q.pollFirst());}int size(){return q.size();}}
 public static void main(String[] args){var b=new BoundedBuffer<String>(1);System.out.println(b.offer("first")+" "+b.offer("backpressure"));}
}
