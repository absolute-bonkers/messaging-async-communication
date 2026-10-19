# Event Streaming

**Roadmap coverage:** Kafka; Google Pub/Sub

Event streams persist an ordered log for independent consumers to read by offset/subscription. This example keeps events and consumer positions, enabling replay and independent progress.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.stream.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Logs and subscriptions

Kafka exposes partitioned retained logs and consumer-group offsets; Google Pub/Sub exposes topics and subscriptions with managed delivery/acknowledgement behavior. Both support decoupled consumers, but ordering scope, retention, replay, delivery, and scaling guarantees differ. The local example models append plus offset reads only.

## Trade-offs

Replay and multiple consumer groups enable new projections, but retention, partition ordering, schema evolution, and lag must be managed.

## Anti-patterns to avoid

Treating a retained event log like a task queue with destructive consumption, or assuming global ordering across partitions.

## Sources

[Apache Kafka documentation](https://kafka.apache.org/documentation/), [Google Cloud Pub/Sub overview](https://cloud.google.com/pubsub/docs/overview)
