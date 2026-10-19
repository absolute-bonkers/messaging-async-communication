# Saga Pattern

**Roadmap coverage:** Orchestration vs Choreography

A saga coordinates a multi-service business transaction as local transactions plus compensating actions. Orchestration centralizes decisions; choreography communicates through events and distributes control.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.saga.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Orchestration and choreography

An orchestrator persists saga state and sends commands, making central flow and timeouts visible. Choreography has services react to events, reducing central control but making the overall state harder to discover. Both need idempotent steps, retry policies, deadlines, observability, and compensations designed for business meaning.

## Trade-offs

Sagas avoid a global database transaction but provide eventual consistency, compensation complexity, and observable intermediate states. Compensation is a new business action, not always a true rollback.

## Anti-patterns to avoid

Assuming compensation can erase irreversible effects, omitting timeout/retry/idempotency rules, or mixing orchestration and event choreography without clear ownership.

## Sources

[Saga pattern](https://microservices.io/patterns/data/saga.html)
