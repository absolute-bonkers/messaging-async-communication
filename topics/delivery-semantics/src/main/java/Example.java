package learning.messaging.delivery;
import java.util.*;
public final class Example {
 static List<String> ordered(List<String> events){return List.copyOf(events);}
 static Set<String> applyOnce(List<String> ids){Set<String> processed=new LinkedHashSet<>();ids.forEach(processed::add);return processed;}
 public static void main(String[] args){System.out.println(applyOnce(List.of("e1","e1","e2")));}
}
