# Message Ordering & Exactly-Once Delivery

**Roadmap coverage:** Message Ordering; Exactly-Once Delivery

Ordering is normally scoped to a queue, key, partition, or session—not necessarily global. “Exactly once” is an end-to-end effect that requires coordinated state/transactions or idempotency; many brokers provide at-least-once delivery.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.delivery.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Scoping guarantees

Ordering is commonly per partition/key/session, not across all producers. At-most-once can lose work; at-least-once can duplicate it. Exactly-once processing needs the effect and consumed position coordinated transactionally, or an idempotent/deduplicated effect with durable identity. State the scope, failure model, and retention window behind any guarantee.

## Trade-offs

Strict ordering can reduce parallelism; deduplication requires stable event IDs and retained state. Broker guarantees do not make arbitrary external side effects atomic.

## Anti-patterns to avoid

Claiming exactly-once from a producer acknowledgement alone, or processing sequence-sensitive messages concurrently without partitioning by key.

## Sources

[Kafka delivery semantics](https://kafka.apache.org/documentation/#semantics), [Kafka design and transactions](https://kafka.apache.org/documentation/)
