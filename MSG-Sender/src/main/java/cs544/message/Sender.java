package cs544.message;

import org.apache.kafka.common.protocol.types.Field.Str;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender implements CommandLineRunner {
	// @Autowired
	// private RabbitTemplate template;

	@Autowired
	private KafkaTemplate<String, Book> kafkaTemplate;

	@Override
	public void run(String... args) throws Exception {
		// String queue = "hello";
		// String queue = "book";
		// String msg = "Hello World!";
		// Person msg = new Person("Frank");

		String topic = "book";
		// String msg = "Hello Kafka!";

		Book msg = new Book(
				"Beginning Java 8 Fundamentals",
				"978-0-306-40615-7",
				"Kishori Sharan",
				49);
		msg.setId(1);

		kafkaTemplate.send(topic, msg);
		System.out.println("\n########## Sent: " + msg + " to: " + topic);

		// String msg2 = "Hello Kafka!";
		// kafkaTemplate.send(topic, msg2);
		// System.out.println("### Sent: " + msg + " to: " + topic);

		// part A
		// Book msg = new Book(
		// "Beginning Java 8 Fundamentals",
		// "978-0-306-40615-7",
		// "Kishori Sharan",
		// 49);

		// part B
		// msg = new Book(
		// "Beginning Java 8 Fundamentals (updated)",
		// "978-0-306-40615-7",
		// "Kishori Sharan (updated)",
		// 37.25);
		// msg.setId(4);

		// part A & B
		// template.convertAndSend(queue, msg);

		// part D
		// template.convertAndSend(queue, msg, m -> {
		// m.getMessageProperties().getHeaders().put("operation", "update");
		// return m;
		// });

		// System.out.println("Sent: " + msg + " to: " + queue);

		// part C
		// int msg2 = 3;
		// template.convertAndSend(queue, msg2);
		// System.out.println("Sent: " + msg2 + " to: " + queue);
	}
}
