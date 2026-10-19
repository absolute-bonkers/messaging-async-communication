# Outbox Pattern

**Roadmap coverage:** Outbox Pattern

The transactional outbox writes business state and an event record in the same local database transaction. A separate relay publishes pending outbox records; consumers should tolerate duplicate publication.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.outbox.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Relay workflow

Within one database transaction, persist both the domain update and an outbox row. A relay claims/publishes pending rows and marks them delivered after broker acknowledgement; crashes can repeat a publish, so consumers deduplicate. Monitor oldest unrelayed age, retry poison records, and preserve required per-aggregate ordering.

## Trade-offs

Avoids dual-write loss between database and broker, but relay lag, retries, ordering, cleanup, and at-least-once duplicates need handling.

## Anti-patterns to avoid

Publishing to the broker before database commit, marking an outbox row sent before confirmed publication, or assuming relay publishes exactly once.

## Sources

[Transactional outbox pattern](https://microservices.io/patterns/data/transactional-outbox.html)
