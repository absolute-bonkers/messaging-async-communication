# Message Queues

**Roadmap coverage:** RabbitMQ; Amazon SQS

Queues decouple producers from workers: messages remain available until consumed and acknowledged (subject to broker semantics). This in-memory example models delivery, receipt-handle acknowledgement, and retry without conflating message IDs with delivery IDs.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.messaging.queue.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Queue delivery lifecycle

RabbitMQ work queues and SQS queues both support asynchronous work, but differ in protocol, broker operation, visibility/acknowledgement, ordering, and retention options. Consumers should process idempotently, acknowledge only after durable work, bound retries, and set visibility/ack timeouts longer than expected processing (with extension where appropriate).

## Trade-offs

Queues smooth bursts and isolate availability, but add duplicate delivery, visibility/ack timeouts, and operational dependencies. Design consumers to be idempotent.

## Anti-patterns to avoid

Acknowledging before durable work completes, assuming exactly-once queue delivery, or publishing messages without a schema/ownership plan.

## Sources

[RabbitMQ work queues](https://www.rabbitmq.com/tutorials/tutorial-one-java), [Amazon SQS](https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/welcome.html)
