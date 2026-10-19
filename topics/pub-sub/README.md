# Publish/Subscribe Pattern

**Roadmap coverage:** Pub/Sub Pattern

In pub/sub, publishers emit events without naming individual consumers; each subscription receives its own delivery. This example fans out one event to independent subscriber queues.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.pubsub.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Roles and delivery

Publishers know a topic/event contract, not the subscriber list. A broker fans out to subscriptions; each subscription owns its cursor, filter, retry, and backlog. Pub/sub differs from competing consumers on one queue: each independent subscription is meant to receive its own copy under the broker's delivery contract.

## Trade-offs

Fan-out enables loose coupling but increases delivery volume and makes subscriber lifecycle, filtering, retries, and ordering semantics explicit concerns.

## Anti-patterns to avoid

Using pub/sub for work that must be handled by exactly one competing worker without a queue/subscription configuration that guarantees that intent.

## Sources

[Google Cloud Pub/Sub overview](https://cloud.google.com/pubsub/docs/overview)
