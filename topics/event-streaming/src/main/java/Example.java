package learning.messaging.stream;
import java.util.*;
public final class Example {
 static final class Log {private final List<String> events=new ArrayList<>();int append(String e){events.add(e);return events.size()-1;}List<String> read(int from,int limit){if(from<0||limit<0)throw new IllegalArgumentException("Offset and limit must not be negative");int end=(int)Math.min(events.size(),(long)from+limit);return List.copyOf(events.subList(Math.min(from,events.size()),end));}int size(){return events.size();}}
 public static void main(String[] args){var log=new Log();log.append("created");log.append("paid");System.out.println(log.read(0,10));}
}
