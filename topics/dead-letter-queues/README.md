# Dead Letter Queues

**Roadmap coverage:** Dead Letter Queues

A dead-letter queue (DLQ) isolates messages that exceed retry or rejection policies for inspection, repair, and controlled redrive. This example routes after a bounded attempt count.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.dlq.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## DLQ operations

Route after a bounded delivery/receive count or explicit rejection. Preserve original payload and relevant headers, failure reason, attempt history, and correlation ID; alert an owner, inspect/redact safely, fix the cause, and redrive deliberately. Redrive should be idempotent and rate-limited to avoid a second incident.

## Trade-offs

DLQs prevent poison messages from blocking normal traffic, but create a second workflow: alerting, ownership, retention, safe replay, and remediation.

## Anti-patterns to avoid

Silently dropping DLQ messages, redriving without fixing the cause, or making a DLQ an infinite retry loop.

## Sources

[Amazon SQS DLQs](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/sqs-dead-letter-queues.html)
