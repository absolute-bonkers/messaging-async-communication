package learning.messaging.dlq;
import java.util.*;
public final class Example {
 record Result(boolean deadLetter,int attempts) {}
 static Result outcome(int attempts,int max){if(max<1||attempts<0)throw new IllegalArgumentException();return new Result(attempts>=max,attempts);}
 public static void main(String[] args){System.out.println(outcome(5,5));}
}
