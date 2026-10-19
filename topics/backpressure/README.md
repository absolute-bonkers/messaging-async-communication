# Backpressure Handling

**Roadmap coverage:** Backpressure Handling

Backpressure makes producers respect downstream capacity. This bounded queue example rejects or pauses work rather than accumulating unlimited memory. Reactive Streams formalizes asynchronous demand signaling.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.backpressure.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Capacity controls

Use bounded queues, demand/request signaling, concurrency limits, admission control, and explicit rejection/drop policies. Backpressure should propagate upstream before buffers exhaust; when upstream cannot pause, shed or persist work according to business priority. Avoid immediate retries, which multiply load during saturation.

## Trade-offs

Bounded buffers protect memory and downstreams, but require explicit overflow behavior, timeouts, and fairness; dropping is only safe for some event classes.

## Anti-patterns to avoid

Unbounded in-memory queues, retrying immediately under overload, or applying backpressure only after requests have already overwhelmed the dependency.

## Sources

[Reactive Streams specification](https://www.reactive-streams.org/), [Kafka consumer configuration](https://kafka.apache.org/documentation/)
